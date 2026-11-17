# Five-Letter Word Game
**Java · Fall 2024 · Interactive console application**

A small word-guessing game with file-loaded words, three difficulty levels, and per-letter feedback.

## Code tour

- [Wordle.java](src/wordle/Wordle.java) loads the word list, selects a target, stores game settings, and evaluates guesses.
- [WordleDemo.java](src/wordle/WordleDemo.java) handles input, the attempt loop, and the win/loss result.
- [wordle_words.txt](wordle_words.txt) contains the bundled word list.

## Run

From the repository root:

```sh
cd coursework-showcase/word-game
javac -encoding UTF-8 -d build src/wordle/*.java
java -cp build wordle.WordleDemo
```

Choose **1** for eight guesses, **2** for six, or **3** for four. Enter a five-letter guess. The program marks correct positions, letters present elsewhere, and absent letters.

## Engineering choices

The game state and input loop live in separate classes. Input words are normalized to uppercase; the word file is read into an array before the target is selected.

## Scope

This is a coursework interpretation of a word game. Repeated-letter feedback uses simple membership checks rather than full duplicate-letter accounting. Guesses are checked for length, not dictionary membership. The word file must exist and contain entries; the difficulty prompt expects a number. A UTF-8 terminal is recommended for the feedback symbols.

The source is preserved as uploaded. Original course period: Fall 2024, based on the source archive and my account of the coursework. [Source notes](../SOURCES.md) · [All projects](../README.md)
