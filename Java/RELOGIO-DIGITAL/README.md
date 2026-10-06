# PROJETO RELÓGIO DIGITAL UTILIZANDO JAVAFX

# COMO FOI FEITO?
O projeto foi feito no Java Development Kit 22, utilizando a biblioteca externa JavaFX 22.

# EXPLICANDO DECISÕES
O projeto utiliza a biblioteca JavaFX 22 para o Front-End.

O projeto utiliza principalmente bibliotecas locais do Java como LocalDateTime e DateTimeFormatter.

A constante DateTimeFormatter FORMATADOR define o padrão da exibição das horas.

O projeto é estilizado com um arquivo Style.css.

O palco utiliza dois Objetos keyFrame: 

- O primeiro utiliza uma expressão lambda para alterar a Label que exibe o horário.
- O segundo objeto KeyFrame define o intervalo de 1 segundo.

O palco também utiliza um Objeto Timeline responsável por receber os KeyFrames e decidir quantas vezes essa timeline deve ser executada. (No caso do projeto, definida como "INDEFINITE" para rodar sem parar)

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22, e a biblioteca externa JavaFX na versão 22.0.1

No terminal do seu sistema operacional:

COMPILAÇÃO: javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls ProjetoRelogioDigital.java

EXECUÇÃO: java --module-path "%PATH_TO_FX%" --add-modules javafx.controls ProjetoRelogioDigital
