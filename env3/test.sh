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
java Env < input.txt

echo
echo
echo "** TEST 2 : Access before declaration **"
echo "** Expected : RuntimeException \"Referenced unknown symbol: a\" ** "
echo
java Env < input-2.txt

echo
echo
echo "** TEST 3 : Access & no declaration **"
echo "** Expected : RuntimeException \"Referenced unknown symbol: b\" ** "
echo
java Env < input-3.txt

echo
echo
echo "** TEST 4 : Correct formatting **"
echo "** Expected : Same as test 1 but with bigger numbers ** "
echo
java Env < input-4.txt

echo
echo 
echo "** TESTS COMPLETE **"
