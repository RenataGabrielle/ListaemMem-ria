```markdown
# CRUD com Spring Boot MVC, Lista em Memória e H2 + JPA

## 📌 Descrição do Projeto
Este projeto é uma aplicação web desenvolvida em **Spring Boot** utilizando o padrão arquitetural **MVC (Model-View-Controller)**.  
A aplicação expõe uma **API REST** que realiza operações de **CRUD** sobre mensagens, inicialmente armazenadas em memória (`List<Mensagem>`) e posteriormente persistidas em banco de dados **H2** via **Spring Data JPA**.

---

## 🎯 Funcionalidades
- **Create:** Adicionar nova mensagem  
  `POST /mensagens`  
- **Read:** Listar todas as mensagens  
  `GET /mensagens`  
- **Read:** Buscar mensagem por ID  
  `GET /mensagens/{id}`  
- **Update:** Atualizar mensagem existente  
  `PUT /mensagens/{id}`  
- **Delete:** Remover mensagem  
  `DELETE /mensagens/{id}`  

---

## 🛠 Tecnologias e Dependências
- Java 21
- Spring Boot 3.5.6
- Spring Web
- Spring Data JPA
- Spring DevTools
- H2 Database

---

## 📁 Estrutura do Projeto
```

src/main/java/com/exemplo/mensagem
├─ Application.java
├─ controller
│   └─ MensagemController.java
├─ model
│   └─ Mensagem.java
├─ service
│   └─ MensagemService.java
└─ repository
└─ MensagemRepository.java

````

---

## ⚙️ Configuração do Banco (H2)
No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
````

* **Console do H2:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 🚀 Executando a Aplicação

1. Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

2. Entre na pasta do projeto:

```bash
cd nome-do-projeto
```

3. Execute a aplicação usando Maven ou sua IDE favorita:

```bash
mvn spring-boot:run
```

4. Acesse a API via **Postman**, **Insomnia** ou navegador (para GETs).

---

## 📌 Exemplos de Requisições HTTP (JSON)

**Criar mensagem:**

```http
POST /mensagens
Content-Type: application/json

{
  "texto": "Minha primeira mensagem"
}
```

**Listar todas as mensagens:**

```http
GET /mensagens
```

**Buscar mensagem por ID:**

```http
GET /mensagens/1
```

**Atualizar mensagem:**

```http
PUT /mensagens/1
Content-Type: application/json

{
  "texto": "Mensagem atualizada"
}
```

**Excluir mensagem:**

```http
DELETE /mensagens/1
```

---

## 📌 Observações

* Inicialmente os dados são armazenados em memória (`List<Mensagem>`).
* Após configuração do H2, os dados passam a ser persistidos no banco em memória.
* O console do H2 permite visualizar e consultar os registros diretamente pelo navegador.

---

Quer que eu faça isso?
```
