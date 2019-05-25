# uni7-loja-spring

Projeto que visa construir aplicação Spring.

### Tecnologias utilizadas

- Java 8
- Maven
- Spring Boot
- Spring Data Jpa
- Flyway
- H2


### Instalação Docker

- Gerar a imagem do projeto Loja, através dos comandos:
```sh
docker build -t loja .
```
```sh
docker run -p 9990:9990 -p 8080:8080 loja
```

### Urls

Todas as urls responderão no formato **JSON**.

#### Cliente

```sh
GET - http://localhost:8080/loja/clientes
GET - http://localhost:8080/loja/clientes/{id}
POST - http://localhost:8080/loja/clientes
{
	"nome": "igor"
}
PUT - http://localhost:8080/loja/clientes/{id}
{
	"nome": "joão"
}
DELETE - http://localhost:8080/loja/clientes/{id}
```
#### Produto 

```
GET - http://localhost:8080/loja/produtos
GET - http://localhost:8080/loja/produtos/{id}
DELETE - http://localhost:8080/loja/produtos/{id}
POST - http://localhost:8080/loja/produtos
{
	"nome": "arroz",
	"valor": "1.0"
}
PUT - http://localhost:8080/loja/produtos/{id}
{
	"valor": "1.5"
}
```

#### Pedido 

```
GET - http://localhost:8080/loja/pedidos
GET - http://localhost:8080/loja/pedidos/{id}
DELETE - http://localhost:8080/loja/pedidos/{id}
POST - http://localhost:8080/loja/pedidos
{
  "cliente" : {
    "id" : "1"
  }
}
PUT - http://localhost:8080/loja/pedidos/{id}
{
  "status": "Cancelado"
}

POST - http://localhost:8080/loja/pedidos/{id}/adicionar-produto/{idProduto}/quantidade/{quantidade}
POST - http://localhost:8080/loja/pedidos/{id}/remover-produto/{idProduto}/quantidade/{quantidade}
PUT - http://localhost:8080/loja/pedidos/{id}/cancelar
PUT - http://localhost:8080/loja/pedidos/{id}/finalizar
```

#### Estoque 

```
GET - http://localhost:8080/loja/estoque
GET - http://localhost:8080/loja/estoque/findAll
GET - http://localhost:8080/loja/estoque/{id}
DELETE - http://localhost:8080/loja/estoque/{id}

GET - http://localhost:8080/loja/estoque/produto/{idProduto}
PUT - http://localhost:8080/loja/estoque/produto/{id}/aumentar/{quantidade}
PUT - http://localhost:8080/loja/estoque/produto/{id}/diminuir/{quantidade}
POST - http://localhost:8080/loja/estoque
{
	"itens": {
		"produto": "1",
		"reposicao": "1",
		"quantidade": "1" 
	}
}
PUT - http://localhost:8080/loja/estoque/{id}
{
	"ativo": "False"
}
```

#### Reposicao 

```
GET - http://localhost:8080/loja/reposicoes
GET - http://localhost:8080/loja/reposicoes/{id}
PUT - http://localhost:8080/loja/reposicoes/{id}/cancelar
PUT - http://localhost:8080/loja/reposicoes/{id}/processar
DELETE - http://localhost:8080/loja/reposicoes/{id}

POST - http://localhost:8080/loja/reposicao
{
	"id": "4",
  "ativo": "True"
}
PUT - http://localhost:8080/loja/reposicao/{id}
{
	"status": "Cancelado"
}
```
