package org.lemanoman.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/**
 * Dado um CEP válido, deve retornar o endereço correspondente OK
 * 
 * Dado um CEP válido, que não exista o endereço, deve substituir um digito da
 * direita para a esquerda por zero até que o endereço seja localizado (Exemplo:
 * Dado 22333999 tentar com 22333990, 22333900 …) OK
 * 
 * Dado um CEP inválido, deve retornar uma mensagem reportando o erro:
 * "CEP inválido" OK
 * 
 * @param args
 */
