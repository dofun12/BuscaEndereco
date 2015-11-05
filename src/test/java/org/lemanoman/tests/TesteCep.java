package org.lemanoman.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lemanoman.model.BuscaModel;
import org.lemanoman.model.ResponseModel;
import org.lemanoman.model.StatusResponse;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.core.status.Status;

public class TesteCep {
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
    public void testarCEPInvalido() {

	BuscaModel busca = new BuscaModel();
	busca.setCep("07202512000");

	ResponseModel model = restTemplate.postForObject(defaultContext + "buscaCEP", busca, ResponseModel.class);
	assertEquals(model.getResponse(),StatusResponse.CEP_INVALIDO);
    }

    /**
    * Teste para verificar o comportamento de um cep existente. 
    */
    
    @Test
    public void testarCEPNormal() {
	BuscaModel busca = new BuscaModel();
	busca.setCep("07025120");

	ResponseModel model = restTemplate.postForObject(defaultContext + "buscaCEP", busca, ResponseModel.class);
	assertEquals(model.getResponse(),StatusResponse.CEP_ENCONTRADO);

    }

    /**
     * Teste para verificar o comportamento de um cep desconhecido. 
     * Quando um cep é desconhecido o cep deve ser substituido o último numero da direita por zero, 
     * até que encontre um endereço.
     */
    
    @Test
    public void testarCEPDesconhecido() {
	BuscaModel busca = new BuscaModel();
	busca.setCep("07025125");

	ResponseModel model = restTemplate.postForObject(defaultContext + "buscaCEP", busca, ResponseModel.class);
	assertEquals(model.getCep(), "07025120".replaceAll("[^0-9]", ""));
	assertEquals(model.getResponse(),StatusResponse.CEP_ENCONTRADO);

    }

}