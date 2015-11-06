package org.lemanoman.buscaendereco.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lemanoman.buscaendereco.model.BuscaModel;
import org.lemanoman.buscaendereco.model.ResponseModel;
import org.lemanoman.buscaendereco.model.StatusResponse;
import org.lemanoman.buscaendereco.tests.exercicio3.ExercicioInterface;
import org.lemanoman.buscaendereco.tests.exercicio3.StreamImpl;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.core.status.Status;

public class TesteExercicio3 {
     

    /**
    * Teste do exercicio 03:
    * 
    * Apartir de um texto, deve mostrar o primeiro caracter que não repete.
    * 
    * Exemplo: aAbBABac
    * 
    * O primeiro caracter a não se repetir é o 'b'
    * 
    */
    
    @Test
    public void testarExercicioInterface() {
	StreamImpl stream = new StreamImpl("aAbBABac");
	assertEquals('b',ExercicioInterface.firstChar(stream));
    }

}
