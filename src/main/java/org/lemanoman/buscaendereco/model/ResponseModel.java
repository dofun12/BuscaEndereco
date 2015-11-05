package org.lemanoman.buscaendereco.model;

public class ResponseModel {
    private String rua;
    private String bairro;
    private String estado;
    private String uf;
    private String cep;
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

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
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
	switch (this.response) {
	case CEP_DESCONHECIDO:
	    return "CEP desconhecido";
	case CEP_ENCONTRADO:
	    return "CEP encontrado";
	case CEP_INVALIDO:
	    return "CEP inválido";
	default:
	    break;
	}
	return "";
    }
    
    public StatusResponse getResponse() {
        return response;
    }

    public void setResponse(StatusResponse response) {
	this.response = response;
    }

}
