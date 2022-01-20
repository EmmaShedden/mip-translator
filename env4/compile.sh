#!/bin/bash

echo
echo "** COMPILING... **"
echo

jjtree env.jjt
echo
javacc env.jj
echo
javac Env.java
echo

echo
echo "** COMPILATION COMPLETE **"
echo