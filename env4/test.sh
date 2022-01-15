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
echo

echo "** TEST 1 : Correct formatting **"
echo "** Expected : {a=Integer, b=Float, c=Float : -0.0 .. 1.0, d=Integer : -10 .. 0} **"
echo
java Env output-1.mzn < input-1.txt

echo
echo
echo "** TEST 2 : Access before declaration **"
echo "** Expected : RuntimeException \"Referenced unknown symbol: a\" ** "
echo
java Env output-2.mzn < input-2.txt

echo
echo
echo "** TEST 3 : Access & no declaration **"
echo "** Expected : RuntimeException \"Referenced unknown symbol: b\" ** "
echo
java Env output-3.mzn < input-3.txt

echo
echo
echo "** TEST 4 : Correct formatting **"
echo "** Expected : Same as test 1 but with bigger numbers ** "
echo
java Env output-4.mzn < input-4.txt

echo
echo
echo "** TEST 5 : Infinity & negative infinity **"
echo "** Expected : Accept, but Symbol Table Builder catches nonsensical bounds ** "
echo
java Env output-5.mzn < input-5.txt

echo
echo
echo "** TEST 6 : Infinity & negative infinity **"
echo "** Expected : Accept completely ** "
echo
java Env output-6.mzn < input-6.txt

echo
echo 
echo "** TESTS COMPLETE **"
