# MIP-translator

This folder contains my working drafts of the environment model components

You probably care about `env4`, as everything else is old

## Index

**env1:** 
-   just recognize the grammar

**env2:**
-   generate a tree for the grammar

**env3:**
-   generate tree
-   use visitor to generate symbol table

**env4:** \[IN PROGRESS\]
-   generate tree
-   use visitor to generate symbol table
-   \[P\] use visitor to generate MiniZinc program
    -   this exists & is even sort of tested
-   \[P\] supports infinity in integer bounds
    -   this exists & is even sort of tested
-   \[P\] started boolean support but then gave up, technically you can declare a boolean but won't be able to assign anything logical to it
-   \[STATE\] currently, test inputs 1, 3, 4, & 6 are expected to produce an output MiniZinc file, because they're the only ones that are formatted correctly according to the parser & Symbol Table Builder
-   \[TODO\] make sure MiniZinc Program Builder actually looks at number values, not just the name parameter, so that the output formatting isn't quirky

## Usage

`java Env inputfile.txt` to run on an environment model file (outputs to terminal)

`java Env` to run on input from terminal (outputs to terminal)
- Note: ctrl+d to end input

`./test.sh` to recompile and run all available tests (in `env3` and above)

To compile manually: 
```console
> jjtree env.jjt
> javacc env.jj
> javac Env.java
> java Env [file.txt]
```

Remember to manually recompile any other modified `.java` files
