package org.lemanoman.buscaendereco.tests.exercicio3;

public class StreamImpl implements Stream{
	String value;
	int i = 0;

	public StreamImpl(String value) {
	    this.value = value;
	} 

	@Override
	public char getNext() {
	    char c = value.charAt(i++);
	    return c;
	}

	@Override
	public boolean hasNext() {
	    if((i+1)>value.length()){
		return false;
	    }else{
		return true;
	    }
	}

}

