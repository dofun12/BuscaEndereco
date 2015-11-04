package org.lemanoman.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.lemanoman.model.EnderecoModel;
import org.lemanoman.services.EnderecoService;

public class Main {
    /**
     * Dado um CEP válido, deve retornar o endereço correspondente OK
     * 
     * Dado um CEP válido, que não exista o endereço, deve substituir um digito da direita para a esquerda por zero até que o endereço seja localizado (Exemplo: Dado 22333999 tentar com 22333990, 22333900 …) OK
     * 
     * Dado um CEP inválido, deve retornar uma mensagem reportando o erro: "CEP inválido" OK
     * 
     * @param args
     */
    public static void main(String[] args) {
	
	
	
    }
}
