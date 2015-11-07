# BuscaEndereco #
Um aplicativo que utiliza rest para buscar o endereço por um cep

### Tecnologias: ###

<b>Ambiente</b>
- IDE: Eclipse Mars
- Restful framework: Spring Boot
- Testes: JUnit 4
- Gerenciador de dependencias : Maven
- (Oracle) Java SDK version: 1.8

<b>Front-End (Tela) </b>
- Angular JS 
- Bootstrap
- JQuery


<b>Utilizados para "parsear" o site dos correios</b>
- HTML Parser: Jsoup
- HTTP Client: Apache HTTP Components
  

### Inicio Rápido ###

- Baixe o arquivo [BuscaEndereco-1.0.0.jar](https://github.com/dofun12/BuscaEndereco/releases/download/v1.0/BuscaEndereco-1.0.0.jar)

- Usando o JDK 1.8 da Oracle(importante), execute o seguinte comando:
```
	java -jar BuscaEndereco.jar
```	
- Na página do seu browser acesse:
[http://localhost:8080](http://localhost:8080) 

E prontinho!!



- Para testar o metodo GET:
	- Entre no seu browser e digite a seguinte URL:
	- [http://localhost:8080/buscaCEP/04571060](http://localhost:8080/buscaCEP/04571060)
	- Onde o valor "04571060" é o cep selecionado
	
- Se a resposta for algo semelhante a :
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
O web service esta funcionando corretamente :D
	

### Métodos

#### GET
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

---

### POST
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

