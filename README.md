# CtoJavaBytecodeCompiler
Generowanie klas parsera:
```
java -jar ./antlr-4.13.1-complete.jar MyParser.g4 MyLexer.g4 -o .\src\antlrGen
```
Dekompilacja czesciowa bytecode:
```
javap -v Main.class
```
Interpretacja class filu:
```
java -noverify Main
```
