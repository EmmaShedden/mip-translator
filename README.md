# MIP-translator

This folder contains my working drafts of the environment model components

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
-   use visitor to generate MiniZinc program

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
