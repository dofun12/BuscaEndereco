package org.lemanoman.buscaendereco.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.lemanoman.buscaendereco.model.EnderecoModel;
import org.lemanoman.buscaendereco.model.ResponseModel;
import org.springframework.web.client.RestTemplate;

public class TesteCRUDCep {
    private RestTemplate restTemplate;
    private String defaultContext;

    /**
     * Rotina de inicialização, aqui é onde se verifica se o serviço rest esta disponível, utililizando um simples GET.
     * E inicia o as variaveis que serão usados nos demais testes.
     * @throws Exception
     */
    
    @Before
    public void setUp() throws Exception {
	restTemplate = new RestTemplate();
	defaultContext = "http://localhost:8080/";

	ResponseModel result = restTemplate.getForObject(defaultContext + "buscaCEP/072025120", ResponseModel.class);
	if(result==null){
	    fail("Serviço não disponível, por inicie antes de testar");    
	}
	
    }

    /**
    * Teste para verificar o comportamento de um cep inválido
    */
    
    @Test
    public void testarInsert() {
	ResponseModel responseModel = new ResponseModel();
	responseModel.setBairro("Vila Magica");
	responseModel.setCidade("Guarulhos");
	responseModel.setCep("07025120");
	responseModel.setComplemento("APT");
	responseModel.setNumero("333");
	responseModel.setUf("SP");
	responseModel.setRua("Qualquer");
	responseModel.setId(responseModel.getCep()+":"+responseModel.getNumero());
	
	restTemplate.postForObject(defaultContext + "saveCEP", responseModel, ResponseModel.class);
	
	EnderecoModel[] enderecosSalvos = restTemplate.getForObject(defaultContext + "listCEPS", EnderecoModel[].class);
	assertNotNull(enderecosSalvos[0]);
    }
    
    @Test
    public void testarConsulta() {
	ResponseModel responseModel = new ResponseModel();
	responseModel.setBairro("Vila Magica");
	responseModel.setCidade("Guarulhos");
	responseModel.setCep("07025120");
	responseModel.setComplemento("APT");
	responseModel.setNumero("6666");
	responseModel.setUf("SP");
	responseModel.setRua("Qualquer");
	responseModel.setId(responseModel.getCep()+":"+responseModel.getNumero());
	
	restTemplate.postForObject(defaultContext + "saveCEP", responseModel, ResponseModel.class);
	
	EnderecoModel[] enderecosSalvos = restTemplate.getForObject(defaultContext + "listCEPS", EnderecoModel[].class);
	assertNotNull(enderecosSalvos);
	assertTrue(enderecosSalvos.length>0);
    }
    
    @Test
    public void testarDelete() {
	ResponseModel responseModel = new ResponseModel();
	responseModel.setBairro("Vila Magica");
	responseModel.setCidade("Guarulhos");
	responseModel.setCep("07025125");
	responseModel.setComplemento("APT");
	responseModel.setNumero("5555");
	responseModel.setUf("SP");
	responseModel.setRua("Qualquer");
	responseModel.setId(responseModel.getCep()+":"+responseModel.getNumero());
	
	restTemplate.postForObject(defaultContext + "saveCEP", responseModel, ResponseModel.class);
	
	EnderecoModel[] enderecosSalvos = restTemplate.getForObject(defaultContext + "listCEPS", EnderecoModel[].class);
	assertNotNull(enderecosSalvos[0]);
	
	restTemplate.postForObject(defaultContext + "removerCEP", responseModel, ResponseModel.class);
	
	EnderecoModel[] enderecosSalvos2 = restTemplate.getForObject(defaultContext + "listCEPS", EnderecoModel[].class);
	if(enderecosSalvos2!=null){
    	   for(EnderecoModel endereco:enderecosSalvos2){
    	       assertFalse(endereco.getId().equals(responseModel.getId()));
    	   }
	}
    }

}
