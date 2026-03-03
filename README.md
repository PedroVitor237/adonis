# 🏋️ ADONIS - Sistema de Gestão para Personal Trainers

Sistema web desenvolvido em **Spring Boot** para gerenciamento de alunos e personal trainers.

Projeto acadêmico desenvolvido para a disciplina de **Banco de Dados** do curso **Análise e Desenvolvimento de Sistemas - UEMA**.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Lombok
- MySQL
- Maven
- HTML + CSS
- Git & GitHub

---

## 📌 Funcionalidades Implementadas

✔ Cadastro de Alunos  
✔ Cadastro de Personal Trainers  
✔ Relacionamento Aluno ↔ Personal    
✔ Listagem, edição e exclusão  

---

## 🗂 Estrutura do Projeto

- `model` → Entidades JPA
- `repository` → Interfaces do Spring Data
- `service` → Regras de negócio
- `controller` → Camada de apresentação (Thymeleaf) e API REST para futura aplicação front-end em React.js
- `templates` → Páginas HTML
- `static` → CSS e arquivos estáticos

---

## 🧠 Arquitetura

O sistema segue o padrão:

MVC (Model - View - Controller)

Relacionamentos principais:

- Usuario (1:1) Aluno
- Usuario (1:1) PersonalTrainer
- PersonalTrainer (1:N) Aluno

---

## ⚙️ Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/PedroVitor237/adonis.git
```

2. Configure o banco MySQL:

```sql
CREATE DATABASE mydb;
```

3. Configure o `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

4. Execute o projeto:

```bash
./mvnw spring-boot:run
```

<!--
  ## 📚 Autor

Pedro Vitor
Curso: Análise e Desenvolvimento de Sistemas  
Universidade Estadual do Maranhão - UEMA
-->

---

## 🔮 Próximas Implementações

- Autenticação com Spring Security
- Dashboard Personal Trainer
- Dashboard Aluno
- Dashboard Administrativo 
- Melhorias no layout (CSS ou Tailwind)
- Sistema de Treinos de Cadastro
- Sistema de Pagamentos

---

⭐ Projeto em evolução...
