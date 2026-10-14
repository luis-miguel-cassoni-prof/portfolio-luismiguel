# PROJETO DE INFORMAÇÕES METEOROLÓGICAS

## COMO FOI FEITO?

O projeto foi desenvolvido em Java, utilizando o JDK 22. Ele consulta a API [WeatherAPI](https://www.weatherapi.com/docs/) para obter as condições climáticas atuais de uma cidade e apresenta os dados no terminal.

A biblioteca externa **JSON-java (`org.json`)** é utilizada para interpretar a resposta recebida no formato JSON.

## EXPLICANDO AS DECISÕES

O projeto está dividido em duas classes:

- **`Aplicacao.java`:** contém o método `main`, recebe o nome da cidade digitado pelo usuário e coordena a consulta e a exibição das informações.
- **`ProjetoClimatico.java`:** lê a chave da API, monta a requisição HTTP, envia a solicitação para a WeatherAPI e interpreta os dados climáticos recebidos.

A chave de acesso é lida do arquivo `api_key.txt`, evitando que ela precise ficar escrita diretamente no código-fonte. O nome da cidade é codificado com UTF-8 antes de ser incluído na URL da requisição.

Quando a resposta é recebida, o programa utiliza a biblioteca `org.json` para extrair e exibir as seguintes informações:

- Cidade e país;
- Data e hora da última atualização;
- Temperatura atual e sensação térmica;
- Condição do tempo;
- Umidade;
- Velocidade do vento;
- Pressão atmosférica.

O programa também verifica o código de erro utilizado pela API quando uma localização não é encontrada e utiliza `try-catch` para tratar exceções durante a execução.

## CONCEITOS E TECNOLOGIAS TRABALHADOS

- Programação Orientada a Objetos;
- Consumo de API externa por meio de requisições HTTP;
- `HttpClient`, `HttpRequest` e `HttpResponse`;
- Manipulação de URLs com `URI` e `URLEncoder`;
- Leitura de arquivos com Java NIO (`Files` e `Paths`);
- Interpretação de JSON com a biblioteca `org.json`;
- Entrada de dados com `Scanner`;
- Tratamento de exceções com `try-catch`.

## COMO RODAR O PROJETO

### Requisitos

- JDK 22 instalado;
- Conexão com a internet;
- Uma chave de API da [WeatherAPI](https://www.weatherapi.com/);
- A biblioteca **JSON-java (`org.json`)**, disponível no [Maven Central](https://central.sonatype.com/artifact/org.json/json).

### 1. Configurar a biblioteca JSON-java

Baixe o arquivo JAR da biblioteca `org.json:json` pelo Maven Central. Dentro da pasta do projeto, crie uma pasta chamada `lib` e coloque o JAR nela, renomeando-o para `json.jar`.

### 2. Configurar a chave da API

Na pasta principal do projeto, crie um arquivo chamado `api_key.txt`. Dentro dele, coloque somente sua chave da WeatherAPI, sem aspas.

A estrutura ficará semelhante a esta:

```text
INFO-METEREOLOGICAS/
├── Aplicacao.java
├── ProjetoClimatico.java
├── api_key.txt
└── lib/
    └── json.jar
```

**Importante:** não compartilhe sua chave nem a envie para o GitHub. O arquivo `api_key.txt` é uma configuração local e deve permanecer privado.

### 3. Compilar

Abra o terminal na pasta do projeto e execute:

```bat
javac -cp ".;lib/json.jar" Aplicacao.java ProjetoClimatico.java
```

### 4. Executar

Após compilar, execute:

```bat
java -cp ".;lib/json.jar" Aplicacao
```

O programa solicitará o nome de uma cidade. Digite a localização desejada e pressione Enter para consultar as condições climáticas atuais.

> Os comandos acima utilizam o separador de classpath do Windows (`;`). Para executar em Linux ou macOS, substitua-o por `:`.
