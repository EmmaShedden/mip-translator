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
-   supports infinity in integer bounds
-   MiniZinc Program Builder actually looks at number values, not just the name parameter, so that the output formatting isn't quirky
-   \[P\] use visitor to generate MiniZinc program
    -   this exists but obviously the requirements part is missing
    -   \[TODO\] separate different parts (recursive vs static problem components)
-   \[P\] started boolean support but then gave up, technically you can declare a boolean & it will pass the AST layer but appear Null or otherwise confuse things everywhere else
-   \[STATE\] currently, test inputs 1, 3, 4, & 6 are expected to produce an output MiniZinc file, because they're the only ones that are formatted correctly according to the parser & Symbol Table Builder



## Usage

`java Env inputfile.txt` to run on an environment model file (outputs to terminal)

`java Env` to run on input from terminal (outputs to terminal)
- Note: ctrl+d to end input

`./compile.sh` to recompile the main stuff (note this doesn't recompile auto generated files outside of the central chain)

`./test.sh [--build | -b]` to (optionally recompile and) run all available tests (in `env4` and above)

To compile manually: 
```console
> jjtree env.jjt
> javacc env.jj
> javac Env.java
> java Env [file.txt]
```

Remember to manually recompile any other modified `.java` files
