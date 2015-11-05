# BuscaEndereco #
Um aplicativo que utiliza rest para buscar o endereço por um cep

### Tecnologias: ###

<b>Ambiente</b>
- IDE: Eclipse Mars
- Restful framework: Spring RESTful Web Service
- Testes: JUnit 4
- Construtor: Maven
- Java sdk version: 1.8

<b>Utilizados para "parsear" o site dos correios</b>
- HTML Parser: Jsoup
- HTTP Client: Apache HTTP Components
  

### Iniciando o web service ###

- Baixe o arquivo [BuscaEndereco-1.0.0.jar](https://github.com/dofun12/BuscaEndereco/releases/download/v1.0/BuscaEndereco-1.0.0.jar)

- Usando o JDK 1.8 da Oracle, execute o seguinte comando:
```
	java -jar BuscaEndereco-1.0.0.jar
```	

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

