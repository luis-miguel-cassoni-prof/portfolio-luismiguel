# PROJETO JOGO DA FORCA SIMPLES JAVA

# COMO FOI FEITO?
O projeto foi feito utilizando Java 22, utilizando somente as bibliotecas oferecidas pelo próprio Java

# EXPLICANDO DECISÕES
Irei separar este tópico por arquivos.

# JogoDaForca.java

Este arquivo possui uma array constante chamada PALAVRAS, contendo varias palavras predefinidas para iniciar o jogo.

O arquivo possui um método para escolher uma das palavras chamado escolherPalavra().

O método utiliza uma Objeto da Classe Random Java. *(Não utilizei o Secure Random pois o projeto é mais simples e um Random simples garante mais desempenho em troca de previsibilidade matemática)*

Uma variável local recebe o índice com limite baseado no tamanho do array da constante.

Após isso o método retorna uma palavra contendo o índice aleatório escolhido.

# Aplicacao.java

A aplicação possui mais parâmetros, então para resumir em tópicos:
- Scanner input importa a classe Scanner do Java para ler entradas do usuário.
- JogoDaForca jogo instancia a Classe JogoDaForca criando um Objeto chamado jogo.
- String palavra recebe um método escolherPalavra() do objeto jogo.
- Uma estrutura das Collections ArrayList chamada letrasDescobertas é criada. Esse ArrayList recebe apenas caracteres.
- Um loop for que percorre o tamanho da palavra e adiciona um caractere para representar a letra a ser descoberta.
- São criadas um boolean palavraDescoberta definida como false, e um inteiro tentativas para definir quantas tentativas você possui.
- Uma estrutura de repetição roda enquanto palavraDescoberta for falso e o número de tentativas for maior que zero.

Como aqui é mais conceitual e ocorrem varias verificações, vamos ampliar a visão um pouco:
- Uma estrutura de repetição macro lê todas as entradas enquanto a palavra não for descoberta e ainda houverem tentativas restantes.
- Caso o número de tentativas se esgote antes da palavra ser descoberta, você perde.
- Caso você acerte, o número de tentativas não é esgotado e a letra substitui um '_' na ArrayList letrasDescobertas,
- Após o fim, ele verifica se você venceu ou perdeu e exibe qual era a palavra.

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22.

No terminal do seu sistema operacional:

COMPILAÇÃO: javac Aplicacao.java

EXECUÇÃO: java Aplicacao
