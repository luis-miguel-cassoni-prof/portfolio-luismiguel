# PROJETO GERADOR DE SENHA SEGURAS SIMPLES

# COMO FOI FEITO?
O projeto foi feito utilizando Java 22, utilizando somente as bibliotecas oferecidas pelo próprio Java

# EXPLICANDO DECISÕES
O projeto possui uma pasta chamada "gerador". Nela está localizada a classe que importa SecureRandom.

COMO GERADOR FUNCIONA?
- A constante final CARACTERES recebe todos os caracteres disponíveis no gerador.
- O método gerarSenha recebe a quantidade de caracteres que a senha deve gerar.
- O método cria uma instância de SecureRandom para escolher valores aleatórios, e uma instância de StringBuilder para facilitar a alteração de Strings.
- Em um laço de repetição a variável indice recebe um índice aleatório da constante CARACTERES.
- A variável senha recebe um caractere de seu respectivo índice.
- Ao final, o método retorna a String completa com a senha gerada.

O método Main está na classe denominada "Aplicacao".

COMO A APLICAÇÃO FUNCIONA?
- Por meio do Objeto Scanner, da classe java Scanner, inicializado e devidamente fechado para não ocorrer nenhum vazamento de memória, os inputs do usuário são lidos.
- Uma instância da classe Gerador no pacote Gerador lê seus métodos.
- Com um tratamento try-catch que pode prever Input de tipo indevido (InputMismatchException), é inicializado o processo de receber os dados.
- O próprio Scanner já impede entradas de tipo null, mas caso elas ocorram, um tratamento preventivo captura NullPointerException e encerra a aplicação em segurança.
- Ao receber a quantia de caracteres desejados, o método gerarSenha() é chamado e recebe a quantia de caracteres.
- Uma condicional consegue impedir que a senha gerada tenha menos de 8 caracteres. Ela fecha o Scanner e retorna, finalizando o programa sem nenhum vazamento de memória.
- Ao final, o programa retorna a senha.

Conceitos Trabalhados:
- Aleatoriedade segura com a classe SecureRandom.
- Programação Orientada a Objetos.
- Inputs do Usuário.
- Geração de senhas com caracteres definidos em uma constante.

# COMO RODAR O PROJETO
Para rodar o projeto você precisa ter instalado o JDK (Java Development Kit) na versão 22.

No terminal do seu sistema operacional:

COMPILAÇÃO: javac Aplicacao.java

EXECUÇÃO: java Aplicacao
