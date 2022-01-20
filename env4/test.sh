#!/bin/bash
if [ "$1" == "-b" ] || [ "$1" == "--build" ]
then
    bash compile.sh
fi

declare -a label=(
    "Correct formatting"
    "Access before declaration"
    "Accepted, with comments ignored"
    "Correct formatting"
    "Infinity & negative infinity"
    "Infinity & negative infinity"
)

declare -a expected=(
    "{a=Integer, b=Float, c=Float : -0.0 .. 1.0, d=Integer : -10 .. 0}"
    "RuntimeException \"Referenced unknown symbol: a\""
    "{a=Float}"
    "{a=Integer, b=Float, c=Float : -0.0 .. 4.0, d=Integer : -10 .. 0, e=Integer : -5678 .. -74, f=Float : -8.8 .. 42.0}"
    "AST accepts, but Symbol Table Builder catches nonsensical bounds"
    "{a=Integer : -infinity .. 0, b=Integer : 0 .. infinity, c=Integer}"
)

for ((i=1; i<=${#label[@]}; i++))
do
    echo -e "\n\n** TEST ${i} : ${label[i-1]} **"
    echo -e "** Expected : ${expected[i-1]} **\n"

    java Env "output-${i}.mzn" < "input-${i}.txt"
    
    echo

    #if [ -f "ast-${i}.txt" ]
    #then
    #    diff "ast-${i}.txt.correct" "ast-${i}.txt"
    #fi

    if [ -f "output-${i}.mzn" ]
    then
        diff "output-${i}.mzn.correct" "output-${i}.mzn"
    fi
done

echo "** TESTS COMPLETE **"
