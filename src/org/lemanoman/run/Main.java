package org.lemanoman.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
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

public class Main {
    /**
     * Dado um CEP válido, deve retornar o endereço correspondente OK
     * 
     * Dado um CEP válido, que não exista o endereço, deve substituir um digito da direita para a esquerda por zero até que o endereço seja localizado (Exemplo: Dado 22333999 tentar com 22333990, 22333900 …) OK
     * 
     * Dado um CEP inválido, deve retornar uma mensagem reportando o erro: "CEP inválido" OK
     * 
     * @param args
     */
    public static void main(String[] args) {
	String cepSearch = "07025125";
	
	int lastIndex = cepSearch.length()-1;
	int zeros = 1;
	while(!searchCEP(cepSearch) && lastIndex>0){
	    cepSearch = cepSearch.substring(0, lastIndex);
	    
	    for(int i=0;i<zeros;i++){
		cepSearch = cepSearch+"0";
	    }
	    zeros++;
	    lastIndex--;
	}
	
    }
    
    public static boolean searchCEP(String cepSearch){
	if(isCepValid(cepSearch)){
	    HttpClient client = HttpClientBuilder.create().build();
	    HttpGet get = new HttpGet("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
	    HttpPost post = new HttpPost("http://www.buscacep.correios.com.br/sistemas/buscacep/resultadoBuscaCepEndereco.cfm");
	    try {
		HttpResponse firstPage = client.execute(get);
		int responseCode = firstPage.getStatusLine().getStatusCode();
		//System.out.println(responseCode);
		if(responseCode==200){
		    post.setHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");

		    List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		    urlParameters.add(new BasicNameValuePair("relaxation", cepSearch));
		    urlParameters.add(new BasicNameValuePair("tipoCEP", "ALL"));
		    urlParameters.add(new BasicNameValuePair("semelhante", "N"));

		    post.setEntity(new UrlEncodedFormEntity(urlParameters));

		    HttpResponse secondPage = client.execute(post);
		    //System.out.println(secondPage.getStatusLine().getReasonPhrase());
		    return parseHTML(extractHTML(secondPage),cepSearch);
		}
	    } catch (ClientProtocolException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}else{
	    System.err.println("Cep inválido");
	    return false;
	}
	return false;
    }

    public static String extractHTML(HttpResponse response) throws IllegalStateException, IOException{
	BufferedReader rd = new BufferedReader(new InputStreamReader(response
		.getEntity().getContent()));

	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
	    result.append(line+"\n");
	}
	return result.toString();
    }

    public static boolean parseHTML(String html,String cepSearch){
	String rua = "";
	String bairro = "";
	String estado = "";
	String uf = "";
	String cep = "";

	Document document = Jsoup.parse(html);
	Elements elements = document.getElementsByClass("tmptabela");
	if(elements.size()>0){
	    Element tableresult = elements.get(0);
	    for(Element tr:tableresult.getElementsByTag("tr")){
		Elements td = tr.getElementsByTag("td");
		if(td.size()>0){
		    rua = td.get(0).text();
		    bairro = td.get(1).text();

		    String estadoUF  = td.get(2).text(); 
		    estado = estadoUF.split("/")[0];
		    uf = estadoUF.split("/")[1];

		    cep = td.get(3).text();
		}	
	    }

	    System.out.println("Rua: "+rua);
	    System.out.println("Bairro: "+bairro);
	    System.out.println("Estado: "+estado);
	    System.out.println("UF: "+uf);
	    System.out.println("CEP: "+cep);
	    return true;
	}else{
	    //System.err.println(String.format("O CEP %s não foi encontrado",cepSearch));
	    return false;
	}

    }

    public static boolean isCepValid(String cep){
	return cep.matches("^[0-9]{8}$");
    }

}
