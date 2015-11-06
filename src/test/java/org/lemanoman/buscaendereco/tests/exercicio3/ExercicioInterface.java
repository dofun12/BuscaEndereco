package org.lemanoman.buscaendereco.tests.exercicio3;

public class ExercicioInterface {
    public static char firstChar(Stream input) {
	String lastChar = "";
	char tmpNextChar;
	
	/**
	* Loop principal para leitura de "Stream".
	*/
	while(input.hasNext()){
	    tmpNextChar = input.getNext();
	    String nextChar = (""+input.getNext()+"").toLowerCase();
	    
	    /**
	    * Aqui eu verifico se o ultimo caracter é diferente do proximo. Se for ele retorna o proximo valor.
	    */
	    if(!nextChar.equals(lastChar) && lastChar!=""){
		return tmpNextChar;
	    }
	    lastChar = nextChar;
	}
	return 0;
    }
}
