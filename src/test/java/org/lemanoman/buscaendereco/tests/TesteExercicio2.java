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
import org.lemanoman.buscaendereco.tests.exercicio2.ExercicioInterface;
import org.lemanoman.buscaendereco.tests.exercicio2.StreamImpl;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.core.status.Status;

public class TesteExercicio2 {
     

    /**
    * Teste do exercicio 02:
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
