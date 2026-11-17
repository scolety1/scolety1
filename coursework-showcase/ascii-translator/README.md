# ASCII Translator
**Python · October 17, 2023 · Dictionaries & file processing**

A short Python exercise that loads a character-code table and writes character-by-character translations of three sample sentences. It uses only the Python standard library.

## Code tour

Read [Spencer-Colety-Lab8.py](Spencer-Colety-Lab8.py):

- `create_dictionary` skips the input header, parses rows and builds a dictionary.
- `translate` looks up characters and writes their numeric codes to a file.
- Space and comma receive explicit handling because the supplied table names those entries.
- `main` runs three sample translations using the bundled data.

## Run

From the repository root:

```sh
cd coursework-showcase/ascii-translator
python Spencer-Colety-Lab8.py
```

The program creates or replaces `output-1.txt`, `output-2.txt` and `output-3.txt` in that directory.

## Scope

The input table uses a simple three-field format. Characters missing from the dictionary are silently skipped. This exercise demonstrates dictionaries and text-file operations; it is not a general Unicode encoder.

The source header names Spencer Colety and dates the exercise to October 17, 2023. The original exercise source and sample table are unchanged. Runtime execution has not been repeated for this extraction. [Source notes](../SOURCES.md) · [All coursework](../README.md)
