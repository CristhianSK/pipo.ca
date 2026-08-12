# pipo.ca

Aplicação web para criação e gerenciamento de listas comunitárias de filmes, com funcionalidade de sorteio aleatório de títulos para grupos. Desenvolvida em Java com Spring Boot, Thymeleaf e integração com a API do TMDB.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 3 (Spring Web, Spring Data JPA, WebClient)
- **Template Engine:** Thymeleaf
- **Banco de Dados:** PostgreSQL
- **API Externa:** [TMDB (The Movie Database)](https://www.themoviedb.org/)
- **Gerenciador de Dependências:** Maven

---

## 📌 Funcionalidades

- [x] Gerenciamento de usuários (CRUD)
- [x] Integração com API do TMDB para busca e consulta de filmes
- [ ] Criação e edição de listas de filmes comunitárias
- [ ] Módulo de seleção/sorteio aleatório de filmes com base em listas
- [ ] Avaliações e interações dos usuários

---

## 🚀 Como executar o projeto

### Pré-requisitos
- JDK 21 ou superior
- Maven
- Banco de Dados PostgreSQL instalado e em execução
- Chave de API do TMDB (API Read Access Token)

### Passos para execução

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/pipo.ca.git](https://github.com/seu-usuario/pipo.ca.git)
   cd pipo.ca
   ```

2. **Configurar as credenciais locais:**
   Crie o arquivo `src/main/resources/application-local.yaml` preenchendo suas credenciais:

   ```yaml
   spring:
     application:
       name: pipo-ca

     datasource:
       url: jdbc:postgresql://localhost:5432/pipo_ca_db
       username: seu_usuario_postgres
       password: sua_senha_postgres

     jpa:
       hibernate:
         ddl-auto: update

   tmdb:
     api:
       key: "Sua_Chave_Bearer_Do_TMDB"
   ```

3. **Executar a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acessar a aplicação:**
   Abra no navegador em `http://localhost:8080`