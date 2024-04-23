parser grammar Parser;
options { tokenVocab=Lexer; }

program : decl*;

decl : varDecl | funDecl;

varDecl : typeSpec varDeclList SEMICOLON;

scopedVarDecl : typeSpec varDeclList SEMICOLON;

varDeclList : varDeclInit*;

varDeclInit : varDeclId | varDeclId COLON simpleExp;

varDeclId : ID | ID LSB INT RSB;

typeSpec : INT | BOOL | CHAR;

funDecl : (typeSpec ID LRB params RRB stmt) | (VOID ID LRB params RRB stmt);

params : param*;

param : typeSpec paramId;

paramId : ID | ID LSB INT RSB;

stmt : expStmt | compundStmt | selectStmt | iterStmt | returnStmt | breakStmt;

expStmt exp SEMICOLON | SEMICOLON;

compoundStmt : LCB localDecs stmtList RCB;

stmtList : stmt*;

selectStmt : (IF simpeExlp stmt) | IF simpleExp stmt else stmt;

iterStmt : (WHILE LRB simpleExp RRB stmt) | (FOR LRB varDecl exprStmt expRRB stmt);

returnStmt : (RETURN SEMICOLON) | (RETURN exp SEMICOLON);

breakStmt : BREAK SEMICOLON;

exp : (mutable ASSIGN exp) | (mutable INCREASE exp) | (mutable DECREASE exp) | (mutable SELFMULTIPLY exp) | (mutable SELFDIVIDE exp) | (mutable SELFMODULO exp) | (mutable INCREMENT) | (mutable DECREMENT) | simpleExp;

simpleExp : (simpleExp OR andExp) | andExp;

andExp : (andExp AND unaryRelExp) | unaryRelExp;

unaryRelExp : NOT unaryRelExp | relExp;

relExp : sumExp relop sumExp | mulExp;

relop : LESSEQUAL | GREATEREQUAL | LESS | GREATER | EQUAL | NOT_EQUAL;

sumExp : sumExp sumop mulExp | mulExp;

sumop : PLUS | MINUS;

mulExp : mulExp mulop unaryExp | unaryExp;

mulop : MULTIPLY | DIVIDE | MODULO;

unaryExp : MINUS unaryExp | factor;

factor : mutable | immutable;

mutable : ID | ID LSB INT RSB;

immutable : (LRB exp RRB) | call | constant

call : ID LRB args RRB

args : exp*;

constant : NUMCONST | CHARCONST | STRINGCONST | TRUE | FALSE






