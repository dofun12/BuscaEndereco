package org.lemanoman.buscaendereco.model;


/**
 * CEP_ENCONTRADO é o cep que foi encontrado a primeira instancia.
 * CEP_INVALIDO é o cep inválido.
 * CEP_SUBSTITUIDO é o cep que não foi encontrado a primeira instancia, porém utilizado a logica dos zeros a direita foi encontrado outro cep.
 * CEP_ENCONTRADO é o cep que não foi encontrado a primeira instancia, mesmo depois da logica  dos zeros a direita não foi encontrado outro cep.
 * 
 * @author kevim
 *
 */
public enum StatusResponse {
	CEP_ENCONTRADO,
	CEP_INVALIDO,
	CEP_SUBSTITUIDO,
	CEP_NAO_ENCONTRADO
}
