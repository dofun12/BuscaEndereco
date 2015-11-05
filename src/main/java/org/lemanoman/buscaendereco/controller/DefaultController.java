package org.lemanoman.buscaendereco.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.lemanoman.buscaendereco.model.BuscaModel;
import org.lemanoman.buscaendereco.model.ResponseModel;
import org.lemanoman.buscaendereco.model.StatusResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
public class DefaultController {

    @RequestMapping(value = "/buscaCEP/{cep}", method = RequestMethod.GET, produces = "application/json")
    public ResponseModel buscaCEPGet(@PathVariable String cep) {
	if (isCepValid(cep)) {
	    return this.searchByCEP(cep);
	} else {
	    ResponseModel response = new ResponseModel();
	    response.setResponse(StatusResponse.CEP_INVALIDO);
	    return response;
	}
    }

    @RequestMapping(value = "/buscaCEP", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody ResponseModel buscaCEPPost(@RequestBody BuscaModel buscaModel) {
	String cep = buscaModel.getCep();
	if (isCepValid(cep)) {
	    return this.searchByCEP(cep);
	} else {
	    ResponseModel response = new ResponseModel();
	    response.setResponse(StatusResponse.CEP_INVALIDO);
	    return response;
	}
    }

    /**
     * Nesse metodo, é iniciado um loop onde ele tenta substituir os digitos do cep não encontrado por zero, até que encontre algum endereço válido.
     * @param cepSearch
     * @return
     */
    public ResponseModel searchByCEP(String cepSearch) {
	int lastIndex = cepSearch.length() - 1;
	int zeros = 1;
	ResponseModel model = null;
	while (model == null && lastIndex > 0) {

	    cepSearch = cepSearch.substring(0, lastIndex);

	    for (int i = 0; i < zeros; i++) {
		cepSearch = cepSearch + "0";
	    }
	    zeros++;
	    lastIndex--;
	    model = find(cepSearch);
	}
	return model;

    }

    /**
     * Aqui ele entra no site dos correios.
     *  Salva os cookies no HttpClient, para só então ele enviar o campo CEP via post.
     *  para a próxima página( ainda bem que não tem captcha :D ).
     * @param cepSearch
     * @return
     */
    private ResponseModel find(String cepSearch) {
	if (isCepValid(cepSearch)) {
	    HttpClient client = HttpClientBuilder.create().build();
	    HttpGet get = new HttpGet("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
	    HttpPost post = new HttpPost(
		    "http://www.buscacep.correios.com.br/sistemas/buscacep/resultadoBuscaCepEndereco.cfm");
	    try {
		HttpResponse firstPage = client.execute(get);
		int responseCode = firstPage.getStatusLine().getStatusCode();
		if (responseCode == 200) {
		    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

		    List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		    urlParameters.add(new BasicNameValuePair("relaxation", cepSearch));
		    urlParameters.add(new BasicNameValuePair("tipoCEP", "ALL"));
		    urlParameters.add(new BasicNameValuePair("semelhante", "N"));

		    post.setEntity(new UrlEncodedFormEntity(urlParameters));

		    HttpResponse secondPage = client.execute(post);
		    ResponseModel model = parseHTML(extractHTML(secondPage), cepSearch);
		    return model;
		}
	    } catch (ClientProtocolException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else {
	    return null;
	}
	return null;
    }
    
    

    /**
     * Caso o processo acima, funcione normalmente. 
     * Aqui é parseado o HTML dos correios gerando uma classe ResponseModel, 
     * que é onde fica armazenado o endereço(rua,bairro,estado,uf,cep).
     * @param response
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    private ResponseModel parseHTML(String html, String cepSearch) {
	String rua = "";
	String bairro = "";
	String estado = "";
	String uf = "";
	String cep = "";

	Document document = Jsoup.parse(html);
	Elements elements = document.getElementsByClass("tmptabela");
	if (elements.size() > 0) {
	    Element tableresult = elements.get(0);
	    for (Element tr : tableresult.getElementsByTag("tr")) {
		Elements td = tr.getElementsByTag("td");
		if (td.size() > 0) {
		    rua = td.get(0).text();
		    bairro = td.get(1).text();

		    String estadoUF = td.get(2).text();
		    estado = estadoUF.split("/")[0];
		    uf = estadoUF.split("/")[1];

		    cep = td.get(3).text();

		    ResponseModel responseModel = new ResponseModel();
		    responseModel.setRua(rua);
		    responseModel.setCep(cep);
		    responseModel.setBairro(bairro);
		    responseModel.setEstado(estado);
		    responseModel.setUf(uf);
		    responseModel.setResponse(StatusResponse.CEP_ENCONTRADO);
		    return responseModel;
		}
	    }

	}
	return null;
    }
    
    /**
     * Trecho utilizado para ler o HTTPResponse e transformar em texto. HTML no caso.
     * @param response
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    
    private String extractHTML(HttpResponse response) throws IllegalStateException, IOException {
	BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
	    result.append(line + "\n");
	}
	return result.toString();
    }

    /**
     * Metodo onde se verifica se um cep é válido.
     * 	 Para um CEP ser válido ele precisa ter apenas numeros,
     * 	e não mais nem menos de 8 digitos.
     * @param cep
     * @return
     */
    private boolean isCepValid(String cep) {
	return cep.matches("^[0-9]{8}$");
    }

}
