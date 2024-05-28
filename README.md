# CtoJavaBytecodeCompiler
generowanie klas parsera:
```
java -jar ./antlr-4.13.1-complete.jar MyParser.g4 MyLexer.g4 -o .\src\antlrGen
```
dekompilacja czesciowa bytecode:
```
javap -v Main.class
```
kompilacja class filu:
```
java -noverify Main
```
