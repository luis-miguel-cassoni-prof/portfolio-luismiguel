# PROJETO CALCULADORA IMC

# COMO FOI FEITO?
O projeto foi feito no Java Development Kit 22, utilizando a biblioteca externa JavaFX 22.

# EXPLICANDO DECISÕES
O design do projeto utiliza uma TextArea e 2 botões. O botão abrir, e o botão salvar.

Além disso, há um Objeto FileChooser, configurado para receber apenas arquivos.txt

O Botão abrir tem um método setOnAction() com uma expressão Lambda que roda todos os passos para abrir um arquivo.

Do mesmo modo, o botão salvar tem um método setOnAction() com uma expressão lambda que roda todos os passos para salvar um arquivo.

Ambos usam as Bibliotecas File de Java.IO, e a biblioteca Files de java.nio.

Há também, em ambos, uma condicional para verificar se o arquivo não é nulo, e dentro dele um tratamento de excessão IOException para casos de falha nas operações com arquivos.

Os conceitos trabalhados nesse projeto foram:
- Programação Orientada a Objetos
- JavaFX + Estilização CSS
- Eventos setOnAction() com expressões LAMBDA.
- Tratamento de Excessões utilizando try-catch

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22, e a biblioteca externa JavaFX na versão 22.0.1

No terminal do seu sistema operacional:

COMPILAÇÃO: javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls EditorDeTexto.java

EXECUÇÃO: java --module-path "%PATH_TO_FX%" --add-modules javafx.controls EditorDeTexto
