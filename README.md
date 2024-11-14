# Aplicação para gerenciamento da plataforma de cursos online [Desafio Accenture]

O repositório contém o projeto de gerenciamento de cursos online! Este projeto utiliza o Java com Spring Boot, Hibernate para o uso da ferramenta ORM, e um banco de dados H2 para fornecer uma plataforma de gerenciar alunos, cursos e suas inscrições.

## Visão Geral
A aplicação tem as seguintes funcionalidades:
- Cadastro dos alunos e criação dos cursos.
- Listar os cursos.
- Listar os alunos.
- Inscrição dos alunos nos cursos.
- Listar os cursos inscrito por um aluno.
- Listar os alunos inscrito em um curso.


## Tecnologias usadas
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database
- Maven
- Postman

## Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- Maven 3.6.3 ou superior
- IDE de sua preferência (IntelliJ, Eclipse, etc.)

## Endpoints da API (Exemplos utilizados no Postman)

#### Cadastrar Alunos

- **URL**: `/alunos`
- **Método**: `POST`
- **Corpo**:
  ```json
  [
    {
      "nome": "Maria Ciclana",
      "email": "maria@email.com",
      "dataCadastro": "2024-11-13"
    },
    {
      "nome": "João Fulano",
      "email": "joao@email.com",
      "dataCadastro": "2024-11-13"
    }
  ]

### Listar Alunos
- **URL**: `/alunos`
- **Método**: `GET`


### Cadastrar Cursos

- **URL**: `/cursos`
- **Método**: `POST`
- **Corpo**:
  ```json
  [
    {
      "nome": "Curso Matemática",
      "descricao": "Matemática do básico ao avançado",
      "dataCriacao": "2024-11-13"
    },
    {
      "nome": "Programação Back-End",
      "descricao": "Curso sobre Java",
      "dataCriacao": "2024-11-13"
    }
  ]

### Listar Cursos
- **URL**: `/cursos`
- **Método**: `GET`

## Inscrever aluno em curso

- **URL**: `/inscricao`
- **Método**: `POST`
- **Corpo**:
  ```json
  {
    "alunoId": 1,
    "cursoId": 1
  }

### Listar cursos por aluno
- **URL**: `/inscricao/aluno/{alunoId}`
- **Método**: `GET`

### Listar aluno por curso
- **URL**: `/inscricao/curso/{cursoId}`
- **Método**: `GET`

## Agradecimentos!

Muito obrigado por esse desafio, foi uma boa experiência e me deu mais vontade de aprender mais! Se precisar de mais alguma coisa ou tiver outras dúvidas, estou à disposição para ajudar! 😊
