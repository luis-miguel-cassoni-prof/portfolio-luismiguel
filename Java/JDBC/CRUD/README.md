# CRUD de Produtos — Java, JavaFX e MySQL

Aplicação desktop para gerenciamento de estoque de produtos. O projeto utiliza **JavaFX** para a interface gráfica, **JDBC** para acessar o banco de dados e **MySQL** para armazenar os registros.

## Funcionalidades

- Cadastrar produtos com nome, quantidade, preço e status.
- Listar os produtos cadastrados em uma tabela.
- Selecionar um produto para carregar seus dados no formulário.
- Atualizar e excluir o produto selecionado.
- Limpar o formulário.
- Consultar produtos por ID e executar operações de teste pelo console.

Cada produto possui um ID gerado pelo banco, nome, quantidade, preço e status (`Disponivel` ou `Indisponivel`).

## Tecnologias utilizadas

- Java 22
- JavaFX 22.0.1
- JDBC
- MySQL
- MySQL Connector/J 9.4.0

## Organização dos arquivos

| Arquivo | Responsabilidade |
| --- | --- |
| `Produto.java` | Modelo que representa um produto e seus atributos. |
| `ProdutoDAO.java` | Operações de acesso a dados: inserir, listar, consultar por ID, atualizar e excluir produtos. |
| `ConexaoDB.java` | Cria a conexão JDBC com o MySQL. |
| `LerCredenciais.java` | Lê o usuário e a senha do banco a partir de arquivos locais. |
| `CriadorTabela.java` | Cria a tabela `produtos`, caso ainda não exista. |
| `ProdutoGUI.java` | Interface gráfica JavaFX para gerenciar os produtos. |
| `TestsMain.java` | Executa operações de teste pelo console. |

## Requisitos

Antes de executar, tenha instalado/configurado:

1. JDK 22.
2. MySQL Server em execução.
3. JavaFX SDK 22.0.1.
4. MySQL Connector/J 9.4.0.
5. Uma variável de ambiente `PATH_TO_FX` apontando para a pasta `lib` do JavaFX SDK.

Os comandos abaixo são para o **Prompt de Comando (CMD) do Windows** e devem ser executados dentro da pasta `Java/JDBC/CRUD`.

## Configuração do banco de dados

A classe `ConexaoDB` utiliza esta URL:

```text
jdbc:mysql://localhost:3306/jdbc
```

Crie o banco de dados `jdbc` no MySQL antes de executar o projeto:

```sql
CREATE DATABASE jdbc CHARACTER SET utf8mb4;
```

### Credenciais locais

Crie a pasta `userdata` dentro da pasta do projeto e adicione estes arquivos:

```text
CRUD/
├── userdata/
│   ├── user.txt
│   └── password.txt
```

- `user.txt`: usuário do MySQL.
- `password.txt`: senha desse usuário.

O usuário do banco precisa ter permissão para criar a tabela e executar operações de leitura e escrita no banco `jdbc`. Os arquivos de texto são ignorados pelo Git para evitar o envio acidental de credenciais ao repositório. **Não coloque senhas reais no código nem as publique no GitHub.**

Observação: atualmente, `LerCredenciais` lê o conteúdo dos arquivos literalmente. Evite espaços ou quebras de linha extras após o usuário e a senha.

### Driver JDBC

Deixe o arquivo do MySQL Connector/J neste caminho:

```text
lib/mysql-connector-j-9.4.0.jar
```

A pasta `lib` deve estar dentro da pasta `CRUD`. O arquivo JAR é uma dependência externa e precisa estar disponível localmente para compilar e executar a aplicação.

### Criar a tabela

Depois de configurar o banco e as credenciais, compile os arquivos e execute a classe `CriadorTabela`. Ela cria a tabela `produtos`, com as colunas:

- `id_produto`: chave primária com incremento automático.
- `nome`: nome do produto.
- `quantidade`: quantidade em estoque.
- `preco`: preço decimal.
- `status`: `Disponivel` ou `Indisponivel`.

## Compilar e executar

### 1. Compilar

No CMD, dentro da pasta `Java/JDBC/CRUD`, execute:

```bat
javac --module-path %PATH_TO_FX% --add-modules javafx.controls -cp "lib/mysql-connector-j-9.4.0.jar;." *.java
```

### 2. Criar a tabela no banco

```bat
java -cp ".;lib/mysql-connector-j-9.4.0.jar" CriadorTabela
```

### 3. Iniciar a interface gráfica

```bat
java --module-path %PATH_TO_FX% --add-modules javafx.controls -cp ".;lib/mysql-connector-j-9.4.0.jar" ProdutoGUI
```

A janela será aberta com o formulário de produto e a tabela dos registros disponíveis.

## Testes pelo console

A classe `TestsMain` demonstra inserção, consulta por ID, atualização e exclusão:

```bat
java -cp ".;lib/mysql-connector-j-9.4.0.jar" TestsMain
```

**Atenção:** `TestsMain` chama `excluirTodos()` ao final da execução e, portanto, apaga todos os registros da tabela `produtos`. Execute esse teste somente em um banco de desenvolvimento, com dados que possam ser descartados.

## Observações

- A aplicação espera que o MySQL esteja acessível localmente na porta `3306`, conforme a URL definida em `ConexaoDB`.
- A entrada de preço aceita ponto ou vírgula como separador decimal na interface.
- Os comandos usam os caminhos relativos `lib/` e `userdata/`; execute-os a partir da pasta do projeto para que os arquivos sejam encontrados.
