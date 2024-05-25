# CtoJavaBytecodeCompiler
generowanie drzewa:
```
antlr4-parse .\Lexer.g4 .\Parser.g4 program -gui .\program.c
```
dekompilacja czesciowa bytecode:
```
javap -v Main.class
```
kompilacja class filu:
```
java Main
```
