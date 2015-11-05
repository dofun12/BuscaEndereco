package org.lemanoman.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
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

    @Before
    public void setUp() throws Exception {
	restTemplate = new RestTemplate();
	defaultContext = "http://localhost:8080/";

	ResponseModel result = restTemplate.getForObject(defaultContext + "buscaCEP/072025120", ResponseModel.class);
	assertNotNull(result);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testarCEPInvalido() {

	BuscaModel busca = new BuscaModel();
	busca.setCep("07202512000");

	ResponseModel model = restTemplate.postForObject(defaultContext + "buscaCEP", busca, ResponseModel.class);
	assertEquals(model.getResponse(),StatusResponse.CEP_INVALIDO);
    }

    @Test
    public void testarCEPNormal() {
	RestTemplate restTemplate = new RestTemplate();
	BuscaModel busca = new BuscaModel();
	busca.setCep("072025120");

	ResponseModel model = restTemplate.postForObject(defaultContext + "buscaCEP", busca, ResponseModel.class);
	assertEquals(model.getResponse(),StatusResponse.CEP_ENCONTRADO);

    }

    @Test
    public void testarCEPDesconhecido() {
	RestTemplate restTemplate = new RestTemplate();
	BuscaModel busca = new BuscaModel();
	busca.setCep("072025125");

	ResponseModel model = restTemplate.postForObject(defaultContext + "buscaCEP", busca, ResponseModel.class);
	assertEquals(model.getCep(), "072025120");
	assertEquals(model.getResponse(),StatusResponse.CEP_ENCONTRADO);

    }

}
