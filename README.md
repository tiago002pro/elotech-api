# DESAFIO TÉCNICO | JAVA

Gestão de Biblioteca com Recomendação de Livros.

## Pré-requisitos

- JDK 17 ou superior
- Maven 3.10 ou superior

## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/tiago002pro/elotech-api.git
   cd projeto
   docker-compose up (Criação container docker)

## Características
### Criar usuários: ```[POST] /elotech-api/user/save```
### Corpo da Requisição:
```
{
   "name": "Nome do Usuário",
   "email": "email@exemplo.com",
   "registrationDate": "2024-08-18",
   "phone": "44988885555"
}
```
### Resposta:
```
{
   "id": 1,
   "name": "Nome do Usuário",
   "email": "email@exemplo.com",
   "registrationDate": "2024-08-18",
   "phone": "44988885555"
}
```
### Recuperar todos os usuário: ```[GET] /elotech-api/user/all```
### Resposta:
```
[
    {
        "id": 1,
        "name": "Nome do Usuário",
        "email": "email@exemplo.com",
        "registrationDate": "2024-08-18",
        "phone": "44988885555"
    }
]
```
### Recuperar usuário: ```[GET] /elotech-api/user/{id}```
### Resposta:
```
{
    "id": 1,
    "name": "Nome do Usuário",
    "email": "email@exemplo.com",
    "registrationDate": "2024-08-18",
    "phone": "44988885555"
}
```
### Atualizar Usuário: ```[PUT] /elotech-api/user/update```
### Corpo da Requisição:
```
{
    "name": "Nome do Usuário atualizado",
    "email": "email@exemplo.com",
    "registrationDate": "2024-08-18",
    "phone": "44988885555"
}
```
### Resposta:
```
{
    "id": 1,
    "name": "Nome do Usuário atualizado",
    "email": "email@exemplo.com",
    "registrationDate": "2024-08-18",
    "phone": "44988885555"
}
```
### Excluir Usuário: ```[DELETE]: /elotech-api/user/{id}```

### Criar livros: ```[POST] /elotech-api/book/save```
### Corpo da Requisição:
```
{
    "title": "Novo livro",
    "author": "Rick Riordan",
    "isbn": "9999999999",
    "publicationDate": "2023-09-01",
    "category": "Fiction"
}
```
### Resposta:
```
{
    "id": 1,
    "title": "Novo livro",
    "author": "Rick Riordan",
    "isbn": "9999999999",
    "publicationDate": "2023-09-01",
    "category": "Fiction"
}
```
### Recuperar todos os livros: ```[GET] /elotech-api/book/all```
### Resposta:
```
[
    {
        "id": 1,
        "title": "Novo livro",
        "author": "Rick Riordan",
        "isbn": "9999999999",
        "publicationDate": "2023-09-01",
        "category": "Fiction"
    }
]
```
### Recuperar livros: ```[GET] /elotech-api/book/{id}```
### Resposta:
```
{
    "id": 1,
    "title": "Novo livro",
    "author": "Rick Riordan",
    "isbn": "9999999999",
    "publicationDate": "2023-09-01",
    "category": "Fiction"
}
```
### Atualizar livros: ```[PUT] /elotech-api/book/update```
### Corpo da Requisição:
```
{
    "id": 1,
    "title": "Novo livro atualizado",
    "author": "Rick Riordan",
    "isbn": "9999999999",
    "publicationDate": "2023-09-01",
    "category": "Fiction"
}
```
### Resposta:
```
{
    "id": 1,
    "title": "Novo livro atualizado",
    "author": "Rick Riordan",
    "isbn": "9999999999",
    "publicationDate": "2023-09-01",
    "category": "Fiction"
}
```
### Excluir livros: ```[DELETE]: /elotech-api/book/{id}```
### Recomendação de livros: ```[GET] /elotech-api/book/recommendation-books?userId={id}```
### Resposta:
```
[
    {
        "id": 2,
        "title": "Mechanical Properties Research 1987-1988",
        "author": "David J. Fisher",
        "isbn": "9783035707670, 3035707677",
        "publicationDate": "1988-01-01",
        "category": "Computers"
    },
    {
        "id": 3,
        "title": "Local Lattice Rotations and Disclinations in Microstructures of Distorted Crystalline Materials",
        "author": "P. Klimanek, A.E. Romanov, Marc Seefeldt",
        "isbn": "9783035707106, 3035707103",
        "publicationDate": "2002-02-01",
        "category": "Computers"
    }
]
```
### Pesquisa livros no Google Books: ```[GET] /elotech-api/book/search-for-books-on-googke-books?title=teste```
### Resposta:
```
[
    {
        "kind": "books#volume",
        "id": "zqw4DwAAQBAJ",
        "etag": "JKYgwekErDo",
        "selfLink": "https://www.googleapis.com/books/v1/volumes/zqw4DwAAQBAJ",
        "volumeInfo": {...
        },
        "saleInfo": {...
        },
        "accessInfo": {...
        },
        "searchInfo: {...
        }
    }
]
```
### Pesquisa livros no Google Books para adicionar na biblioteca: ```[GET] /elotech-api/book/search-googke-books?title=teste```
### Resposta:
```
[
    {
        "id": "zqw4DwAAQBAJ",
        "title": "Introdução Ao Teste De Software",
        "author": "Marcio Delamaro, Mario Jino, José Maldonado",
        "isbn": "9788535267495, 8535267492",
        "publicationDate": "2013-09-10",
        "category": "Computers",
        "imgLink": "http://books.google.com/books/content?id=zqw4DwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
    }
]
```
### Adiciona livro do Google Books na biblioteca: ```[GET] /elotech-api/book/add-book-to-library?id={id_google_books}```
### Resposta:
```
[
    {
        "id": 1,
        "title": "Introdução Ao Teste De Software",
        "author": "Marcio Delamaro, Mario Jino, José Maldonado",
        "isbn": "9788535267495, 8535267492",
        "publicationDate": "2013-09-10",
        "category": "Computers"
    }
]
```

### Criar empréstimos: ```[POST] /elotech-api/loan/save```
### Corpo da Requisição:
```
{
    "user": {
      "id": 1,
      "name": "Nome do Usuário atualizado",
      "email": "email@exemplo.com",
      "registrationDate": "2024-08-18",
      "phone": "44988885555"
    },
    "book": {
      "id": 1,
      "title": "Novo livro atualizado",
      "author": "Rick Riordan",
      "isbn": "9999999999",
      "publicationDate": "2023-09-01",
      "category": "Fiction"
    },
    "loanDate": "2024-08-12",
    "returnDate": "2024-08-17",
    "status": "OPEN"
}
```
### Resposta:
```
{
    "id": 1,
    "user": {
        "id": 1,
        "name": "Nome do Usuário atualizado",
        "email": "email@exemplo.com",
        "registrationDate": "2024-08-18",
        "phone": "44988885555"
    },
    "book": {
        "id": 1,
        "title": "Novo livro atualizado",
        "author": "Rick Riordan",
        "isbn": "9999999999",
        "publicationDate": "2023-09-01",
        "category": "Fiction"
    },
    "loanDate": "2024-08-12",
    "returnDate": "2024-08-17",
    "status": "OPEN"
}
```
### Atualizar empréstimos: ```[PUT] /elotech-api/loan/update```
### Corpo da Requisição:
```
{
    "id": 1,
    "user": {
      "id": 1,
      "name": "Nome do Usuário atualizado",
      "email": "email@exemplo.com",
      "registrationDate": "2024-08-18",
      "phone": "44988885555"
    },
    "book": {
      "id": 1,
      "title": "Novo livro atualizado",
      "author": "Rick Riordan",
      "isbn": "9999999999",
      "publicationDate": "2023-09-01",
      "category": "Fiction"
    },
    "loanDate": "2024-08-12",
    "returnDate": "2024-08-12",
    "status": "FINISH"
}
```
### Resposta:
```
{
    "id": 1,
    "user": {
      "id": 1,
      "name": "Nome do Usuário atualizado",
      "email": "email@exemplo.com",
      "registrationDate": "2024-08-18",
      "phone": "44988885555"
    },
    "book": {
      "id": 1,
      "title": "Novo livro atualizado",
      "author": "Rick Riordan",
      "isbn": "9999999999",
      "publicationDate": "2023-09-01",
      "category": "Fiction"
    },
    "loanDate": "2024-08-12",
    "returnDate": "2024-08-12",
    "status": "FINISH"
}
```


