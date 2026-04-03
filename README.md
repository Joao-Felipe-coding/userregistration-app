# User Registration App

Este projeto é um aplicativo Android simples para **Cadastro de Usuários**, desenvolvido para fins de aprendizado. Ele utiliza a biblioteca **Room** para persistência de dados local (banco de dados).

---

## Objetivo do Projeto
O app permite que você insira informações de um usuário (Nome, CPF, Email e Telefone) e as salve de forma permanente no dispositivo. Mesmo que você feche o app, os dados continuarão lá.

## Tecnologias Utilizadas
- **Linguagem:** Java
- **Interface:** XML (Layouts)
- **Banco de Dados:** Room Persistence Library (uma camada sobre o SQLite)

---

## Estrutura do Projeto (Explicação Didática)

Para entender como o banco de dados funciona neste app, imagine uma biblioteca real:

### 1. A Entidade (User.java)
Pense na **Entidade** como a "Ficha de Cadastro". Nela definimos quais informações queremos guardar:
- `id`: O número da ficha (gerado automaticamente).
- `name`, `cpf`, `email`, `phone`: Os dados que o usuário preenche.
- **Anotação @Entity**: Diz ao Android que essa classe deve virar uma tabela no banco de dados.

### 2. O DAO (UserDao.java) - Data Access Object
O **DAO** é como se fosse o "Bibliotecário". Ele é uma interface onde definimos **o que** queremos fazer com os dados:
- `@Insert`: "Ei, bibliotecário, guarde esta nova ficha!"
- `@Query("SELECT * FROM user")`: "Ei, bibliotecário, me mostre todas as fichas que você tem!"

### 3. O Banco de Dados (UserDatabase.java)
Este é o "Prédio da Biblioteca". É a classe que une tudo e gerencia a conexão com o arquivo do banco de dados no celular.

---

## Telas do Aplicativo

### MainActivity
É a tela principal. Aqui teremos os campos de texto (EditText) para o usuário digitar os dados e um botão para salvar.
- **Fluxo:** Pegar o texto dos campos -> Criar um objeto User -> Chamar o UserDao para salvar.

### ReportActivity
É a tela de relatório ou listagem.
- **Fluxo:** Chamar o UserDao para buscar todos os usuários -> Exibir em uma lista para o usuário ver quem está cadastrado.

---

## Conceitos Importantes para Lembrar
- **Thread de UI vs. Thread de Background:** O Android não permite salvar dados no banco de dados na "Thread Principal" (a que cuida do visual), pois o app poderia travar. Sempre fazemos operações de banco de dados em segundo plano.
- **Chave Primária (@PrimaryKey):** É o identificador único de cada usuário. Nunca existirão dois usuários com o mesmo ID.

---

## Como navegar no código
- `app/src/main/java/.../`: Contém a lógica em Java.
- `app/src/main/res/layout/`: Contém o desenho das telas em XML.
