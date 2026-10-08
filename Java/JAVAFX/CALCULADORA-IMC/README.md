# PROJETO CALCULADORA IMC

# COMO FOI FEITO?
O projeto foi feito no Java Development Kit 22, utilizando a biblioteca externa JavaFX 22.

# EXPLICANDO DECISÕES
Há uma pasta separada denominada "entidades", ela eu coloquei apenas um método simples para retornar um cálculo de IMC.

O método main está localizado no arquivo Aplicacao.java. Neste arquivo é criado um STAGE de JavaFX para funcionar como interface visual do projeto.

Os conceitos trabalhados nesse projeto foram:
- Programação Orientada a Objetos
- JavaFX + Estilização CSS
- Eventos setOnAction() com expressões LAMBDA.
- Tratamento de Excessões utilizando try-catch

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22, e a biblioteca externa JavaFX na versão 22.0.1

No terminal do seu sistema operacional:

COMPILAÇÃO: javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls Aplicacao.java

EXECUÇÃO: java --module-path "%PATH_TO_FX%" --add-modules javafx.controls Aplicacao
