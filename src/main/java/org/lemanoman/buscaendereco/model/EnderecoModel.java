package org.lemanoman.buscaendereco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.common.base.Objects;

@Entity
public class EnderecoModel {

    @Id
    @NotNull
    @Size(max = 64)
    @Column(name = "id", nullable = false, updatable = true)
    private String id;

    @NotNull
    @Size(max = 64)
    @Column(name = "cep", nullable = false)
    private String cep;

    @NotNull
    @Size(max = 64)
    @Column(name = "rua", nullable = false)
    private String rua;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "numero", nullable = false)
    private String numero;
    
    @Size(max = 64)
    @Column(name = "bairro", nullable = true)
    private String bairro;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @Size(max = 64)
    @Column(name = "complemento", nullable = true)
    private String complemento;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "uf", nullable = false)
    private String uf;

    public EnderecoModel() {
    }

    public EnderecoModel(final String id, final String cep,final String rua,final String cidade,final String uf,final String bairro,final String numero) {
        this.id = id;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.uf = uf;
    }

    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	 
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("rua", rua)
                .add("numero", numero)
                .add("cep", cep)
                .add("cidade", cidade)
                .add("uf", uf)
                .add("bairro", bairro)
                .add("complemento", complemento)
                .toString();
    }
}

