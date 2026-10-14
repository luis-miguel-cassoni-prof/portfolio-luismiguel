# PROJETO MINI LISTA DE COMPRAS JAVA

# COMO FOI FEITO?
O projeto foi feito no Java Development Kit 22, utilizando a biblioteca externa JavaFX 22.

# EXPLICANDO DECISÕES
O projeto foi feito utilizando JavaFX para interfaces desktop, utilizando o módulo controls.

O projeto gera arquivos de listaDeCompra em formato .txt, ele utiliza a estrutura de dados ArrayList, além de recursos do JavaFX como ListView e ObservableList.

Os conceitos trabalhados nesse projeto foram:
- Programação Orientada a Objetos
- JavaFX
- ListView e ObservableList
- Eventos setOnAction() com expressões LAMBDA

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22, e a biblioteca externa JavaFX na versão 22.0.1

No terminal do seu sistema operacional:

COMPILAÇÃO: javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls ProjetoListaDeCompras.java

EXECUÇÃO: java --module-path "%PATH_TO_FX%" --add-modules javafx.controls ProjetoListaDeCompras
