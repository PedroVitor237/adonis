# ADONIS — Sistema de Gestão para Personal Trainers

Adonis é uma aplicação web para cadastrar e gerenciar alunos, personal trainers e seus dados de usuário. O projeto foi desenvolvido na disciplina de **Banco de Dados** do curso de **Análise e Desenvolvimento de Sistemas (ADS) da Universidade Estadual do Maranhão (UEMA)**.

Além da interface web renderizada no servidor, a aplicação expõe endpoints REST para as operações atualmente disponíveis sobre usuários, alunos e personal trainers. O projeto está em desenvolvimento e ainda não possui autenticação ou os fluxos completos de gestão de treinos.

## Tecnologias

- Java 21;
- Spring Boot 4.0.7 e Spring MVC;
- Spring Data JPA e Hibernate;
- Thymeleaf, HTML e CSS;
- MySQL;
- Lombok;
- Maven e Maven Wrapper.

## Funcionalidades implementadas

- página inicial com acesso ao gerenciamento de alunos e personal trainers;
- cadastro, listagem, edição e exclusão de alunos pela interface Thymeleaf;
- cadastro, listagem, edição e exclusão de personal trainers pela interface Thymeleaf;
- criação conjunta dos dados de usuário nos cadastros de aluno e personal trainer;
- atribuição automática do tipo e do status do usuário nesses cadastros;
- listagem de usuários e formulário independente para criação de usuário;
- persistência das entidades em MySQL por meio de repositórios Spring Data JPA;
- endpoints REST para listar, consultar por ID, criar e excluir usuários, alunos e personal trainers.

As entidades `AvaliacaoFisica`, `Exercicio`, `Treino` e `TreinoExercicio` já possuem mapeamentos JPA, repositórios e serviços básicos. No entanto, elas ainda não têm controllers, endpoints ou páginas próprias e, por isso, não constituem fluxos completos disponíveis na aplicação.

## Arquitetura

O projeto combina MVC para as páginas renderizadas pelo Thymeleaf com uma organização em camadas:

```text
Requisição HTTP
      ↓
Controller (views Thymeleaf ou respostas JSON)
      ↓
Service
      ↓
Repository (Spring Data JPA)
      ↓
Hibernate / MySQL
```

Estrutura principal:

- `model`: entidades e enums do domínio;
- `repository`: interfaces que estendem `JpaRepository`;
- `service`: acesso às operações de persistência e regras de atribuição de tipo/status;
- `controller`: controllers MVC e REST;
- `templates`: páginas HTML processadas pelo Thymeleaf;
- `static`: folha de estilos da interface.

Não há um frontend React neste repositório. As páginas atuais são renderizadas no servidor e não consomem os endpoints REST.

## Modelo de dados

Os principais relacionamentos definidos nas entidades JPA são:

- `Aluno` → `Usuario`: `@OneToOne` obrigatório, com chave estrangeira única e cascata;
- `PersonalTrainer` → `Usuario`: `@OneToOne` obrigatório, com chave estrangeira única e cascata;
- `Aluno` → `PersonalTrainer`: `@ManyToOne` opcional — vários alunos podem referenciar o mesmo personal trainer;
- `AvaliacaoFisica` → `Aluno`: `@ManyToOne` obrigatório;
- `Treino` → `Aluno`: `@ManyToOne` obrigatório;
- `TreinoExercicio` → `Treino` e `Exercicio`: dois relacionamentos `@ManyToOne` associados por uma chave composta, com séries, repetições, carga e descanso na entidade de associação.

Os dois relacionamentos com `Usuario` são bidirecionais. Os demais estão mapeados apenas a partir da entidade que contém a chave estrangeira.

## API REST

Os controllers REST retornam e recebem as próprias entidades JPA em JSON; ainda não há DTOs nem uma camada personalizada de respostas ou tratamento global de erros.

| Recurso | Listar | Consultar por ID | Criar | Excluir |
| --- | --- | --- | --- | --- |
| Usuários | `GET /api/usuarios` | `GET /api/usuarios/{id}` | `POST /api/usuarios` | `DELETE /api/usuarios/{id}` |
| Alunos | `GET /api/alunos` | `GET /api/alunos/{id}` | `POST /api/alunos` | `DELETE /api/alunos/{id}` |
| Personal trainers | `GET /api/personal-trainers` | `GET /api/personal-trainers/{id}` | `POST /api/personal-trainers` | `DELETE /api/personal-trainers/{id}` |

A API não possui endpoints `PUT` ou `PATCH`. As edições feitas pelas páginas Thymeleaf utilizam rotas MVC próprias.

## Banco de dados e persistência

A aplicação usa MySQL. O Hibernate está configurado com `spring.jpa.hibernate.ddl-auto=update`, portanto atualiza o esquema a partir das entidades ao iniciar. O repositório não possui ferramenta de migrations, script de carga inicial ou configuração Docker.

As restrições de obrigatoriedade e unicidade são definidas principalmente pelos mapeamentos JPA e pelos atributos `required` dos formulários HTML. Ainda não há validação de entrada com Bean Validation.

## Como executar

### Pré-requisitos

- JDK 21;
- MySQL em execução.

1. Clone o repositório e acesse a pasta do projeto:

   ```bash
   git clone https://github.com/PedroVitor237/adonis.git
   cd adonis
   ```

2. Crie o banco de dados:

   ```sql
   CREATE DATABASE mydb;
   ```

3. Configure `src/main/resources/application.properties`. O arquivo `application-example.properties` contém um modelo; use credenciais locais próprias:

   ```properties
   spring.application.name=adonis
   spring.datasource.url=jdbc:mysql://localhost:3306/mydb
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Execute com o Maven Wrapper:

   ```bash
   ./mvnw spring-boot:run
   ```

   No Windows, use `mvnw.cmd spring-boot:run`.

5. Acesse [http://localhost:8080](http://localhost:8080).

## Estado atual e possíveis evoluções

O projeto implementa os cadastros e as operações básicas de gerenciamento, mas permanece em evolução. São melhorias planejadas ou possíveis:

- autenticação e autorização com Spring Security;
- dashboards específicos para personal trainer, aluno e administração;
- interface e navegação mais completas;
- controllers, endpoints e telas para treinos, exercícios e avaliações físicas;
- gestão de pagamentos.

Enquanto não houver autenticação e proteção adequada das credenciais, a aplicação deve ser tratada como um projeto acadêmico em desenvolvimento, e não como um sistema pronto para uso em produção!

## Autor

[Pedro Vitor](https://github.com/PedroVitor237)

Análise e Desenvolvimento de Sistemas — Universidade Estadual do Maranhão (UEMA)
