# Word Game

Um jogo de adivinhação de palavras desenvolvido em Java, com diferentes níveis de dificuldade e sistema de pontos. O jogador deve adivinhar a palavra correta, podendo usar "jokers" para obter dicas e reiniciar o jogo quando desejar.

## Funcionalidades
- Vários níveis de dificuldade (palavras de 3 a 8 letras)
- Sistema de pontos e "jokers"
- Feedback visual e sonoro para respostas certas e erradas
- Interface simples via console
- Possibilidade de reiniciar o jogo

## Como jogar
1. Execute o arquivo `Main.java` para iniciar o jogo.
2. Siga as instruções no console para adivinhar a palavra.
3. Digite sua resposta e pressione Enter.
4. Use o comando `joker` para utilizar um coringa ou `restart` para reiniciar.

## Estrutura do Projeto
- `src/`
  - `OrganizeGame.java`: Lógica principal do jogo
  - `Player.java`: Gerenciamento do jogador e pontuação
  - `Colors.java`: Códigos de cores para o console
  - `Music.java`: Efeitos sonoros
  - `Wordle.java`, `WordGame.java`: Outras lógicas do jogo
  - Arquivos de palavras por tamanho: `ThreeLettersWords`, `FourLetterWords`, etc.
  - `Assets/`: Arquivos de áudio

## Requisitos
- Java 8 ou superior
- IDE ou terminal para compilar e executar

## Como executar
1. Compile os arquivos Java:
   ```sh
   javac src/*.java
   ```
2. Execute o programa principal:
   ```sh
   java -cp src Main
   ```

## Créditos
Desenvolvido por [Seu Nome].

---
Divirta-se jogando e aprimorando seu vocabulário!

