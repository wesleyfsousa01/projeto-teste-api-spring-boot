# API Projeto TESTE
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/wesleyfsousa01/workshop-spring-boot-mongoDB/edit/master/LICENSE) 

**Objetivo geral:**
- Desenvolver uma API utilizando o framework SpringBoot
-  utilizar banco de dados em memória (HSQLDB ou H2).

**Premissas:**
- Desenvolver um serviço que seja capaz de inserir e recuperar dados.

**Serviços REST:**
- Inserir uma nova venda
- Recuperar lista de vendedores com os campos:
  * Nome
  * Total de vendas
  * Média de vendas por dia, conforme periodo informado por pârametro na URL.

**Descrição:**
O protótipo consiste em um sistema de vendas que permite a gestão de produtos, vendas e vendedores. A aplicação 
segue a arquitetura REST e o padrão MVC.

A API oferece diversos endpoints para realizar operações como inserir novos produtos, registrar vendas, cadastrar vendedores, recuperar informações sobre 
vendedores e obter a média de vendas dos mesmos em um intervalo de tempo específico.

## Endpoints

![POST/produtos](https://github.com/wesleyfsousa01/projeto-teste-api-spring-boot/blob/master/assets/postman/inserir-produto.png)


![POST/vendedores](https://github.com/wesleyfsousa01/projeto-teste-api-spring-boot/blob/master/assets/postman/inserir-vendedor.png)

![POST/vendas](https://github.com/wesleyfsousa01/projeto-teste-api-spring-boot/blob/master/assets/postman/inserir-venda.png)

![GET/vendedores](https://github.com/wesleyfsousa01/projeto-teste-api-spring-boot/blob/master/assets/postman/get-vendedores-por-periodo.png)

## Modelo conceitual
![Modelo Conceitual](https://github.com/wesleyfsousa01/projeto-teste-api-spring-boot/blob/master/assets/modelo-de-dominio.png)

# Tecnologias utilizadas
## Back end
- Java 17
- Spring Boot 3.1.0
- JPA / Hibernate
- Maven
- H2 Database

# Como executar o projeto

Pré-requisitos: 
 * Java 17
 * Maven

```bash
# clonar repositório
git clone https://github.com/wesleyfsousa01/projeto-teste-api-spring-boot.git

# cd /projeto-teste-api-spring-boot

# executar o projeto
mvn spring-boot:run
```




# Autor

Wesley Ferreira

https://www.linkedin.com/in/wesley-fsa/
