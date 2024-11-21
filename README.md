# Spring CRUD Project

## Descrição
Este é um projeto de CRUD básico usando **Spring Boot**, com integração ao banco de dados MySQL. O sistema gerencia duas entidades principais: **Peça** e **Produção**, permitindo operações de criação, leitura, atualização e exclusão (CRUD).

---

## Funcionalidades
- **Gerenciamento de Peças**:
  - Cadastrar, atualizar, buscar e deletar peças.
  - Cada peça possui um código único e um tipo.

- **Gerenciamento de Produções**:
  - Relacionado a peças específicas.
  - Permite definir a ordem de produção, prioridade e tipo.

---

## Tecnologias Utilizadas
- **Java 23**
- **Spring Boot 3.4.0-SNAPSHOT**
- **MySQL**
- **Lombok**
- **Spring Data JPA**
- **Springdoc OpenAPI (Swagger UI)**

---

## Requisitos
1. **Java** (versão 17 ou superior).
2. **Maven** para gerenciar dependências.
3. **MySQL** para o banco de dados.
4. Ferramenta de API Client (como Postman) ou navegador para testar os endpoints.

---

## Configuração do Banco de Dados
1. Configure o banco de dados MySQL no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

2. Crie o banco de dados com o nome especificado na URL (seu_banco).

## Como Rodar o Projeto
1. Clone o repositório:


git clone https://github.com/seu-usuario/spring-crud.git
cd spring-crud

2. Compile e inicie a aplicação:

mvn spring-boot:run

# API Endpoints Documentation

## Peça

![Endpoints da entidade Peça](docs\imgs\swagger-peça.png)
## Produção

![Endpoints da entidade Produção](docs\imgs\swagger-produçao.png)

## Contribuições
Sinta-se à vontade para contribuir com melhorias! Para isso:

Faça um fork do projeto.

Crie uma branch para a sua funcionalidade (git checkout -b minha-feature).

Envie um pull request com as suas alterações.






