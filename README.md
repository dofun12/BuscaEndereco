# BuscaEndereco #
Um aplicativo que utiliza rest para buscar o endereço por um cep

### Tecnologias:

<b>Ambiente</b>
- IDE: Eclipse Mars
- Restful framework: Spring Boot
- Testes: JUnit 4
- Gerenciador de dependencias : Maven
- (Oracle) Java SDK version: 1.8
- Compativel com dispositivos Móveis

<b>Front-End (Tela) </b>
- Angular JS 
- Bootstrap
- JQuery


<b>Utilizados para "parsear" o site dos correios</b>
- HTML Parser: Jsoup
- HTTP Client: Apache HTTP Components
  

## Inicio Rápido

### Windows

- Baixe e instale o JAVA SDK 1.8 da Oracle.

- Baixe o zip [BuscaEndereco.zip](https://github.com/dofun12/BuscaEndereco/blob/master/BuscaEndereco.zip?raw=true)

- Extraia o arquivo no diretório de sua escolha.


- No diretório BuscaEndereço execute o seguinte comando:

```
	maven\bin\mvn package
```	
- Ao executar esse comando, irá baixar todas as dependências do projeto, ou seja, pode demorar um pouco.

```
	java -jar target/BuscaEndereco.jar
```	

- No seu browser acesse o seguinte link [http://localhost:8080](http://localhost:8080) 

  ![Alt text](https://github.com/dofun12/BuscaEndereco/raw/master/images/buscaendereco_homepage.PNG?raw=true "BuscaEndereco Home Page")





### Linux

- Baixe e instale o JAVA SDK 1.8 da Oracle.

- Baixe o zip [BuscaEndereco.zip](https://github.com/dofun12/BuscaEndereco/blob/master/BuscaEndereco.zip?raw=true)

- Extraia o arquivo no diretório de sua escolha.


- No diretório BuscaEndereço execute o seguinte comando:

- Adicione as permissões:
```
	chmod -R 755 ./maven/bin/*
```	
- Depois execute:
```
	./maven/bin/mvn package
```	
- Ao executar esse comando, irá baixar todas as dependências do projeto, ou seja, pode demorar um pouco.

- Para iniciar o servidor, execute o seguinte comando:

```
	java -jar target/BuscaEndereco.jar
```	

- No seu browser acesse o seguinte link [http://localhost:8080](http://localhost:8080) 

  ![Alt text](https://github.com/dofun12/BuscaEndereco/raw/master/images/buscaendereco_homepage.PNG?raw=true "BuscaEndereco Home Page")




---

## Métodos REST

#### Busca de CEP (GET)
```
http://localhost:8080/buscaCEP/{cep}
```
##### Exemplo Envio: 
```
http://localhost:8080/buscaCEP/04571060
```
##### Exemplo Resposta: 
```
{
	"rua":"Rua Taperoá ",
	"bairro":"Cidade Monções ",
	"estado":"São Paulo","uf":"SP",
	"cep":"04571-060",
	"response":"CEP_ENCONTRADO",
	"responseMessage":"CEP encontrado"
}
```

### Busca de CEP (POST)
```
http://localhost:8080/buscaCEP/
```

#### Formato de JSON de envio: 
```
{"cep":"cep" }
```

#### Exemplo Envio:
```
{"cep": "04571060" }
```
#### Exemplo Resposta:
```
{
	"rua":"Rua Taperoá ",
	"bairro":"Cidade Monções ",
	"estado":"São Paulo","uf":"SP",
	"cep":"04571-060",
	"response":"CEP_ENCONTRADO",
	"responseMessage":"CEP encontrado"
}
```
- Obs: O cep é um campo obrigatório
- Sem reposta

### Listar Enderecos Cadastrados
```
http://localhost:8080/listCEPS
```
#### Exemplo Resposta:
```
[{"id":"03267-120:118","cep":"03267-110","rua":"Rua Qualquer ","numero":"999","bairro":"Teste ","cidade":"São Paulo","complemento":null,"uf":"SP"}]
```

### Cadastrar Endereco (POST)
```
http://localhost:8080/saveCEP
```
#### Exemplo Envio:
```
{  
   "id":"03267-120:118",
   "cep":"03267-110",
   "rua":"Rua Qualquer ",
   "numero":"999",
   "bairro":"Teste ",
   "cidade":"São Paulo",
   "complemento":null,
   "uf":"SP"
}
```
- Obs: O id,rua,numero e cidade são campos obrigatórios
- Sem reposta

### Deletar Endereco (POST)
```
http://localhost:8080/removerCEP
```
#### Exemplo Envio:
```
{  
   "id":"03267-120:118"
}
```
- Obs: O id é um campo obrigatório
- Sem reposta

### Classe Para Testes

#### Foram criadas classes para testar o aplicativo(JUnit):
- Elas se encontram no pacote: <b>org.lemanoman.buscaendereco.tests</b>
- <b>TesteCep:</b> Classe criada para testar as repostas de busca de ceps.
- <b>TesteCRUDCep:</b> Classe criada para testar os metodos de Cadastro,Lista e de Delete do aplicativo.
- <b>TesteExercicio3:</b> Classe criada para implementar a classe "Stream" (Exercicio 03).
- <b>TestarTudo:</b> Executa todos os Testes.





