package org.lemanoman.buscaendereco.model;

public class ResponseModel {
    private String id;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;
    private String complemento;
    private StatusResponse response;

    public String getRua() {
	return rua;
    }

    public void setRua(String rua) {
	this.rua = rua;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf;
    }

    public String getCep() {
	return cep;
    }

    public void setCep(String cep) {
	this.cep = cep;
    }

    public String getResponseMessage() {
	if(this.response!=null){
	    switch (this.response) {
	    case CEP_SUBSTITUIDO:
		return "CEP substituido";
	    case CEP_ENCONTRADO:
		return "CEP encontrado";
	    case CEP_INVALIDO:
		return "CEP inválido";
	    default:
		return "";
	    }
	}else{
	    return "";
	}	
    }



    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public StatusResponse getResponse() {
	return response;
    }

    public void setResponse(StatusResponse response) {
	this.response = response;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }


}
