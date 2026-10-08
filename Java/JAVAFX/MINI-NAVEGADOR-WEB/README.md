# PROJETO MINI NAVEGADOR WEB JAVA

# COMO FOI FEITO?
O projeto foi feito no Java Development Kit 22, utilizando a biblioteca externa JavaFX 22.

# EXPLICANDO DECISÕES
O projeto utiliza o módulo WEB do JavaFX, com os imports de WebView e WebEngine

Para pesquisa de sites, é utilizado uma expressão lambda setOnAction.

Nessa expressão, o web engine recebe um método para receber o texto do TextField assim que o usuário aperta enter.

O projeto também possui um método, que aplica, caso necessário, uma formatação caso o usuário esqueça do "http://" ou "https://".

**(Disclaimer: Há MUITAS incompatibilidades no projeto, por se tratar de um módulo já existente da biblioteca JavaFX)** 

Os conceitos trabalhados nesse projeto foram:
- Programação Orientada a Objetos
- JavaFX + Módulo Web
- Eventos setOnAction() com expressões LAMBDA.

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22, e a biblioteca externa JavaFX na versão 22.0.1

No terminal do seu sistema operacional:

COMPILAÇÃO: javac --module-path "%PATH_TO_FX%" --add-modules javafx.web ProjetoMiniNavegador.java

EXECUÇÃO: java --module-path "%PATH_TO_FX%" --add-modules javafx.web ProjetoMiniNavegador
