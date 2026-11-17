# C++ Fundamentals
**C++ · Spring 2024 · Small practice exercises**

Three compact examples from my early C++ coursework. They complement the larger Java projects with direct use of standard-library containers, iterators and file streams.

## Read and run

From the repository root:

```sh
cd coursework-showcase/cpp-fundamentals
g++ -std=c++17 vector.cpp -o vector-demo
g++ -std=c++17 erase.cpp -o list-demo
g++ -std=c++17 find_letter.cpp -o letter-demo
```

Compile each source separately: each has its own `main` function. On Linux/macOS, run `./vector-demo`, `./list-demo`, and `./letter-demo`. On Windows, use the corresponding executable names produced by your compiler.

| Source | Focus |
| --- | --- |
| [vector.cpp](vector.cpp) | Traverse a vector using indexes, a range-based loop and explicit iterators |
| [erase.cpp](erase.cpp) | Erase list elements and follow the iterator returned by `erase` |
| [find_letter.cpp](find_letter.cpp) | Read lines from a file and count occurrences of lowercase `o` |

The file-reading example uses the included [out.txt](out.txt), which contains two lines: `hello` and `world`. Reading the code gives an expected count of two lines and two lowercase `o` characters; this is not a recorded runtime result.

## Context

These are small coursework practice examples, not complete applications or original algorithm inventions. The source is preserved unchanged from the Spring 2024 archive. The file-reading example assumes its input is present and does not report an explicit file-open error.

No compilation was performed for this extraction. [Source notes](../SOURCES.md) · [All coursework](../README.md)
