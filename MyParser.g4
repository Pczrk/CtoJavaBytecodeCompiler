parser grammar MyParser;
options { tokenVocab=MyLexer; }

program : decl*;

decl : varDecl
     | funDecl;

varDecl : varSinDecl | varArrDecl;

varSinDecl : typeSpec varDeclList SEMICOLON;

varArrDecl : typeSpec arrDeclList SEMICOLON;

typeSpec : INT | BOOL | FLOAT | CHAR;

scopedVarDecl : varSinDecl | varArrDecl;

varDeclList : varDeclInit (COMA varDeclInit)*;

arrDeclList : arrDeclInit (COMA arrDeclInit)*;

varDeclInit : varDeclId
            | varDeclId ASSIGN simpleExp;

arrDeclInit : arrDeclId
	    | arrDeclId ASSIGN LCB simpleExp (COMA simpleExp)* RCB;

varDeclId : ID;

arrDeclId : ID LSB intSimpleExp RSB;

funDecl : nonVoidFunDecl | voidFunDecl;

nonVoidFunDecl : sinVoidFunDecl | arrVoidFunDecl;

sinVoidFunDecl : typeSpec ID LRB params RRB nonVoidRStmt;

arrVoidFunDecl : typeSpec LSB RSB ID LRB params RRB nonVoidRStmt;

voidFunDecl : VOID ID LRB params RRB voidRStmt;

params : param*;

param : sinParam | arrParam;

sinParam : typeSpec ID;

arrParam : typeSpec ID LSB RSB ;


nonVoidRStmt : nonVoidReturnStmt | nonVoidRCompoundStmt;

nonVoidRCompoundStmt : LCB (scopedVarDecl | stmt)* nonVoidReturnStmt RCB;
 
stmt : nonVoidReturnStmt | compoundStmt | selectStmt | iterStmt | expStmt;

nonVoidReturnStmt : RETURN simpleExp SEMICOLON;

compoundStmt : LCB (scopedVarDecl | stmt)* RCB;
selectStmt : IF LRB boolSimpleExp RRB stmt
	       | IF LRB boolSimpleExp RRB stmt ELSE stmt;
iterStmt : WHILE LRB boolSimpleExp RRB stmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB stmt;


voidRStmt : voidReturnStmt | compoundStmt;
 
voidReturnStmt : RETURN SEMICOLON;


expStmt : boolExpStmt | intExpStmt | charExpStmt | floatExpStmt | boolArrExpStmt | intArrExpStmt | charArrExpStmt | floatArrExpStmt | SEMICOLON;

exp : boolExp | intExp | charExp | floatExp | boolArrExp | intArrExp | charArrExp | floatArrExp;

simpleExp : boolSimpleExp | intSimpleExp | charSimpleExp | floatSimpleExp | boolArrSimpleExp | intArrSimpleExp | charArrSimpleExp | floatArrSimpleExp;

boolExpStmt : boolExp SEMICOLON;
intExpStmt : intExp SEMICOLON;
charExpStmt : charExp SEMICOLON;
floatExpStmt : floatExp SEMICOLON;
boolArrExpStmt : boolArrExp SEMICOLON;
intArrExpStmt : intArrExp SEMICOLON;
charArrExpStmt : charArrExp SEMICOLON;
floatArrExpStmt : floatArrExp SEMICOLON;

boolExp : mutable ASSIGN boolSimpleExp
	| boolSimpleExp;

boolSimpleExp : boolSimpleExp brelop orExp | orExp;

orExp : orExp OR andExp | andExp;

andExp : andExp AND unaryRelExp | unaryRelExp;

unaryRelExp : NOT unaryRelExp | relExp;

relExp : LRB boolSimpleExp RRB
	| boolean
	| call
	| ID
	| ID LSB intSimpleExp RSB
	| LRB BOOL RRB intSimpleExp
	| intSimpleExp relop intSimpleExp
	| charSimpleExp relop charSimpleExp
	| floatSimpleExp relop floatSimpleExp;

boolean : TRUE
         | FALSE;

relop : LESS_EQUAL
      | GREATER_EQUAL
      | LESS
      | GREATER
      | EQUAL
      | NOT_EQUAL;

brelop : EQUAL
      | NOT_EQUAL;

intExp : mutable ASSIGN intSimpleExp
	| mutable INCREASE intSimpleExp
	| mutable DECREASE intSimpleExp
	| mutable SELFMULTIPLY intSimpleExp
	| mutable SELFDIVIDE intSimpleExp
	| intSimpleExp;

intSimpleExp : intSimpleExp sumop intMulExp
		| intMulExp;

sumop : PLUS
      | MINUS;

intMulExp : intMulExp mulop intUnaryExp
	| intUnaryExp;

mulop : MULTIPLY
      | DIVIDE;

intUnaryExp : MINUS intUnaryExp | intFactor;

intFactor : LRB intSimpleExp RRB
	| NUMCONST
	| call
	| ID
	| ID LSB intSimpleExp RSB
	| LRB INT RRB boolSimpleExp
	| LRB INT RRB charSimpleExp
	| LRB INT RRB floatSimpleExp;

call : ID LRB args RRB;

args : simpleExp (COMA simpleExp)* | ;

mutable : ID
	| ID LSB intSimpleExp RSB;

floatExp : mutable ASSIGN floatSimpleExp
	| mutable INCREASE floatSimpleExp
	| mutable DECREASE floatSimpleExp
	| mutable SELFMULTIPLY floatSimpleExp
	| mutable SELFDIVIDE floatSimpleExp
	| floatSimpleExp;

floatSimpleExp : floatSimpleExp sumop floatMulExp
		| floatMulExp;

floatMulExp : floatMulExp mulop floatUnaryExp
	| floatUnaryExp;

floatUnaryExp : MINUS floatUnaryExp | floatFactor;

floatFactor : LRB floatSimpleExp RRB
	| FLOATCONST
	| call
	| ID
	| ID LSB intSimpleExp RSB
	| LRB FLOAT RRB intSimpleExp;

charExp : mutable ASSIGN charSimpleExp;

charSimpleExp : call
	| ID
	| ID LSB intSimpleExp RSB
	| LRB CHAR RRB intSimpleExp;

boolArrExp : mutable ASSIGN boolArrSimpleExp;

boolArrSimpleExp : call
	| ID;

intArrExp : mutable ASSIGN intArrSimpleExp;

intArrSimpleExp : call
	| ID;

charArrExp : mutable ASSIGN charArrSimpleExp;

charArrSimpleExp : call
	| ID;

floatArrExp : mutable ASSIGN floatArrSimpleExp;

floatArrSimpleExp : call
	| ID;



