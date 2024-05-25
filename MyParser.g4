parser grammar MyParser;
options { tokenVocab=MyLexer; }

program : decl*;

decl : varDecl
     | funDecl;

varDecl : boolDecl | intDecl | charDecl | floatDecl | boolArrDecl | intArrDecl | charArrDecl | floatArrDecl;

boolDecl : BOOL boolVarDeclList SEMICOLON;
intDecl : INT intVarDeclList SEMICOLON;
charDecl : CHAR charVarDeclList SEMICOLON;
floatDecl : FLOAT floatVarDeclList SEMICOLON;

boolArrDecl : BOOL boolArrDeclList SEMICOLON;
intArrDecl : INT intArrDeclList SEMICOLON;
charArrDecl : CHAR charArrDeclList SEMICOLON;
floatArrDecl : FLOAT floatArrDeclList SEMICOLON;

scopedVarDecl : boolDecl | intDecl | charDecl | floatDecl | boolArrDecl | intArrDecl | charArrDecl | floatArrDecl;

boolVarDeclList : boolVarDeclInit (COMA boolVarDeclInit)*;
intVarDeclList : intVarDeclInit (COMA intVarDeclInit)*;
charVarDeclList : charVarDeclInit (COMA charVarDeclInit)*;
floatVarDeclList : floatVarDeclInit (COMA floatVarDeclInit)*;

boolArrDeclList : boolArrDeclInit (COMA boolArrDeclInit)*;
intArrDeclList : intArrDeclInit (COMA intArrDeclInit)*;
charArrDeclList : charArrDeclInit (COMA charArrDeclInit)*;
floatArrDeclList : floatArrDeclInit (COMA floatArrDeclInit)*;

boolVarDeclInit : varDeclId
            | varDeclId ASSIGN boolSimpleExp;
intVarDeclInit : varDeclId
            | varDeclId ASSIGN intSimpleExp;
charVarDeclInit : varDeclId
            | varDeclId ASSIGN charSimpleExp;
floatVarDeclInit : varDeclId
            | varDeclId ASSIGN floatSimpleExp;

boolArrDeclInit : arrDeclId
	    | arrDeclId ASSIGN LCB boolSimpleExp (COMA boolSimpleExp)* RCB;
intArrDeclInit : arrDeclId
	    | arrDeclId ASSIGN LCB intSimpleExp (COMA intSimpleExp)* RCB;
charArrDeclInit : arrDeclId
	    | arrDeclId ASSIGN LCB charSimpleExp (COMA charSimpleExp)* RCB;
floatArrDeclInit : arrDeclId
	    | arrDeclId ASSIGN LCB floatSimpleExp (COMA floatSimpleExp)* RCB;


varDeclId : ID;

arrDeclId : ID LSB intSimpleExp RSB;

funDecl : boolFunDecl | intFunDecl | charFunDecl | floatFunDecl | boolArrFunDecl | intArrFunDecl | charArrFunDecl | floatArrFunDecl | voidFunDecl;

boolFunDecl : BOOL ID LRB params RRB boolRStmt;
intFunDecl : INT ID LRB params RRB intRStmt;
charFunDecl : CHAR ID LRB params RRB charRStmt;
floatFunDecl : FLOAT ID LRB params RRB floatRStmt;

boolArrFunDecl : BOOL ID LRB params RRB boolArrRStmt;
intArrFunDecl : INT ID LRB params RRB intArrRStmt;
charArrFunDecl : CHAR ID LRB params RRB charArrRStmt;
floatArrFunDecl : FLOAT ID LRB params RRB floatArrRStmt;

voidFunDecl : VOID ID LRB params RRB voidRStmt;

params : param*;

param : boolParam | intParam | charParam | floatParam | boolArrParam | intArrParam | charArrParam | floatArrParam;

boolParam : BOOL ID;
intParam : INT ID;
charParam : CHAR ID;
floatParam : FLOAT ID;
boolArrParam : BOOL ID LSB RSB;
intArrParam : INT ID LSB RSB;
charArrParam : CHAR ID LSB RSB;
floatArrParam : FLOAT ID LSB RSB;

boolRStmt : boolReturnStmt | boolRCompoundStmt;

boolRCompoundStmt : LCB (scopedVarDecl | boolStmt)* boolReturnStmt RCB;
 
boolStmt : boolReturnStmt | boolCompoundStmt | boolSelectStmt | boolIterStmt | expStmt;

boolReturnStmt : RETURN boolSimpleExp SEMICOLON;

boolCompoundStmt : LCB (scopedVarDecl | boolStmt)* RCB;
boolSelectStmt : IF LRB boolSimpleExp RRB boolStmt
	       | IF LRB boolSimpleExp RRB boolStmt ELSE boolStmt;
boolIterStmt : WHILE LRB boolSimpleExp RRB boolStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB boolStmt;



intRStmt : intReturnStmt | intRCompoundStmt;

intRCompoundStmt : LCB (scopedVarDecl | intStmt)* intReturnStmt RCB;
 
intStmt : intReturnStmt | intCompoundStmt | intSelectStmt | intIterStmt | expStmt;

intReturnStmt : RETURN intSimpleExp SEMICOLON;

intCompoundStmt : LCB (scopedVarDecl | intStmt)* RCB;
intSelectStmt : IF LRB boolSimpleExp RRB intStmt
	       | IF LRB boolSimpleExp RRB intStmt ELSE intStmt;
intIterStmt : WHILE LRB boolSimpleExp RRB intStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB intStmt;



charRStmt : charReturnStmt | charRCompoundStmt;

charRCompoundStmt : LCB (scopedVarDecl | charStmt)* charReturnStmt RCB;
 
charStmt : charReturnStmt | charCompoundStmt | charSelectStmt | charIterStmt | expStmt;

charReturnStmt : RETURN charSimpleExp SEMICOLON;

charCompoundStmt : LCB (scopedVarDecl | charStmt)* RCB;
charSelectStmt : IF LRB boolSimpleExp RRB charStmt
	       | IF LRB boolSimpleExp RRB charStmt ELSE charStmt;
charIterStmt : WHILE LRB boolSimpleExp RRB charStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB charStmt;



floatRStmt : floatReturnStmt | floatRCompoundStmt;

floatRCompoundStmt : LCB (scopedVarDecl | floatStmt)* floatReturnStmt RCB;
 
floatStmt : floatReturnStmt | floatCompoundStmt | floatSelectStmt | floatIterStmt | expStmt;

floatReturnStmt : RETURN floatSimpleExp SEMICOLON;

floatCompoundStmt : LCB (scopedVarDecl | floatStmt)* RCB;
floatSelectStmt : IF LRB boolSimpleExp RRB floatStmt
	       | IF LRB boolSimpleExp RRB floatStmt ELSE floatStmt;
floatIterStmt : WHILE LRB boolSimpleExp RRB floatStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB floatStmt;



boolArrRStmt : boolArrReturnStmt | boolArrRCompoundStmt;

boolArrRCompoundStmt : LCB (scopedVarDecl | boolArrStmt)* boolArrReturnStmt RCB;
 
boolArrStmt : boolArrReturnStmt | boolArrCompoundStmt | boolArrSelectStmt | boolArrIterStmt | expStmt;

boolArrReturnStmt : RETURN boolArrSimpleExp SEMICOLON;

boolArrCompoundStmt : LCB (scopedVarDecl | boolArrStmt)* RCB;
boolArrSelectStmt : IF LRB boolSimpleExp RRB boolArrStmt
	       | IF LRB boolSimpleExp RRB boolArrStmt ELSE boolArrStmt;
boolArrIterStmt : WHILE LRB boolSimpleExp RRB boolArrStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB boolArrStmt;



intArrRStmt : intArrReturnStmt | intArrRCompoundStmt;

intArrRCompoundStmt : LCB (scopedVarDecl | intArrStmt)* intArrReturnStmt RCB;
 
intArrStmt : intArrReturnStmt | intArrCompoundStmt | intArrSelectStmt | intArrIterStmt | expStmt;

intArrReturnStmt : RETURN intArrSimpleExp SEMICOLON;

intArrCompoundStmt : LCB (scopedVarDecl | intArrStmt)* RCB;
intArrSelectStmt : IF LRB boolSimpleExp RRB intArrStmt
	       | IF LRB boolSimpleExp RRB intArrStmt ELSE intArrStmt;
intArrIterStmt : WHILE LRB boolSimpleExp RRB intArrStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB intArrStmt;



charArrRStmt : charArrReturnStmt | charArrRCompoundStmt;

charArrRCompoundStmt : LCB (scopedVarDecl | charArrStmt)* charArrReturnStmt RCB;
 
charArrStmt : charArrReturnStmt | charArrCompoundStmt | charArrSelectStmt | charArrIterStmt | expStmt;

charArrReturnStmt : RETURN charArrSimpleExp SEMICOLON;

charArrCompoundStmt : LCB (scopedVarDecl | charArrStmt)* RCB;
charArrSelectStmt : IF LRB boolSimpleExp RRB charArrStmt
	       | IF LRB boolSimpleExp RRB charArrStmt ELSE charArrStmt;
charArrIterStmt : WHILE LRB boolSimpleExp RRB charArrStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB charArrStmt;



floatArrRStmt : floatArrReturnStmt | floatArrRCompoundStmt;

floatArrRCompoundStmt : LCB (scopedVarDecl | floatArrStmt)* floatArrReturnStmt RCB;
 
floatArrStmt : floatArrReturnStmt | floatArrCompoundStmt | floatArrSelectStmt | floatArrIterStmt | expStmt;

floatArrReturnStmt : RETURN floatArrSimpleExp SEMICOLON;

floatArrCompoundStmt : LCB (scopedVarDecl | floatArrStmt)* RCB;
floatArrSelectStmt : IF LRB boolSimpleExp RRB floatArrStmt
	       | IF LRB boolSimpleExp RRB floatArrStmt ELSE floatArrStmt;
floatArrIterStmt : WHILE LRB boolSimpleExp RRB floatArrStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB floatArrStmt;



voidRStmt : voidReturnStmt | voidCompoundStmt;
 
voidStmt : voidReturnStmt | voidCompoundStmt | voidSelectStmt | voidIterStmt | expStmt;

voidReturnStmt : RETURN SEMICOLON;

voidCompoundStmt : LCB (scopedVarDecl | voidStmt)* RCB;
voidSelectStmt : IF LRB boolSimpleExp RRB voidStmt
	       | IF LRB boolSimpleExp RRB voidStmt ELSE voidStmt;
voidIterStmt : WHILE LRB boolSimpleExp RRB voidStmt
	     | FOR LRB scopedVarDecl boolExpStmt exp RRB voidStmt;



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
	| FLOAT
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



