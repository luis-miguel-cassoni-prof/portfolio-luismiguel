# PROJETO FRONT PARA GERADOR DE SENHA SEGURAS SIMPLES

# COMO FOI FEITO?
O projeto foi feito utilizando Java 22, utilizando a biblioteca externa JavaFX 22.

# EXPLICANDO DECISÕES
Para entender o projeto de Gerador de Senhas entre no link abaixo:

https://github.com/luis-miguel-cassoni-prof/portfolio-luismiguel/tree/main/Java/GERADOR-DE-SENHAS-SEGURAS-SIMPLES

Como funciona o Front-End:
- Ele é feito utilizando JavaFX 22.
- A estilização é feita pela folha de estilos style.css.
- O módulo do JavaFX utilizado é o controls
- A disposição dos elementos é feita em uma VBOX centralizada de resolução 400x300.
- A senha é gerada por meio de uma expressão lambda setOnAction() no botão.
- A senha possui tratamento de erros try-catch para caso de de entradas inválidas, capturando a exceção NumberFormatException.
- Após a geração da senha, ela entra em um TextField que permite que ela seja copiada e colada.

Os conceitos trabalhados foram:
- Programação Orientada a Objetos.
- JavaFX22 + Estilização CSS.
- Expressões Lambda em setOnAction() de botão.
- Tratamento de Exceções

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22, e a biblioteca externa JavaFX na versão 22.0.1.

No terminal do seu sistema operacional:

COMPILAÇÃO: javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls Aplicacao.java

EXECUÇÃO: java --module-path "%PATH_TO_FX%" --add-modules javafx.controls Aplicacao
