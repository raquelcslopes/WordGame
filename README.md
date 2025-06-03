# Word Game

Word Game is a Java-based console application that challenges players to guess words of varying lengths. The game includes different categories of words (three to eight letters) and provides feedback on the accuracy of guesses. It is inspired by classic word-guessing games like Wordle.

## Features
- Multiple word lengths: 3, 4, 5, 6, 7, and 8 letters
- Input validation and error handling
- Score tracking for players
- Sound effects for game over (requires audio support)
- Simple menu navigation

## Requirements
- Java 8 or higher
- (Optional) Audio support for sound effects

## How to Run
1. Clone or download this repository.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans).
3. Compile the project:
   - Using command line: `javac src/*.java`
   - Or use your IDE's build functionality.
4. Run the main class:
   - Using command line: `java -cp src Main`
   - Or run `Main.java` from your IDE.

## Project Structure
- `src/` - Source code directory
  - `Main.java` - Entry point of the application
  - `Menu.java` - Handles menu navigation
  - `Player.java` - Player data and score
  - `OrganizeGame.java` - Game logic
  - `Wordle.java` - Word-guessing logic
  - `Assets/` - Contains sound files
  - Other files - Word lists, exceptions, and helpers

## Customization
- To add or modify word lists, edit the respective files in the `src/` directory (e.g., `FiveLetterWords`, `SixLetterWords`).
- To change sound effects, replace the files in `src/Assets/`.

## License
This project is for educational purposes. Feel free to use and modify it as needed.

