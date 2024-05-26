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

arrDeclId : ID LSB numSimpleExp RSB;

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


expStmt : assignExpStmt | boolExpStmt | numExpStmt | SEMICOLON | printf;

exp : assignExp | boolExp | numExp;

simpleExp : boolSimpleExp | numSimpleExp | charSimpleExp;

boolExpStmt : boolExp SEMICOLON;
numExpStmt : numExp SEMICOLON;
assignExpStmt : assignExp SEMICOLON;
printf : PRINTF LRB simpleExp RRB SEMICOLON;

boolExp : boolSimpleExp;

boolSimpleExp : boolSimpleExp brelop orExp | orExp;

orExp : orExp OR andExp | andExp;

andExp : andExp AND unaryRelExp | unaryRelExp;

unaryRelExp : NOT unaryRelExp | relExp;

relExp : LRB boolSimpleExp RRB
	| boolean
	| call
	| ID
	| ID LSB numSimpleExp RSB
	| LRB BOOL RRB numSimpleExp
	| numSimpleExp relop numSimpleExp
	| charSimpleExp relop charSimpleExp;

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

numExp : mutable INCREASE numSimpleExp
	| mutable DECREASE numSimpleExp
	| mutable SELFMULTIPLY numSimpleExp
	| mutable SELFDIVIDE numSimpleExp
	| numSimpleExp;

numSimpleExp : numSimpleExp sumop numMulExp
		| numMulExp;

sumop : PLUS
      | MINUS;

numMulExp : numMulExp mulop numUnaryExp
	| numUnaryExp;

mulop : MULTIPLY
      | DIVIDE;

numUnaryExp : MINUS numUnaryExp | numFactor;

numFactor : LRB numSimpleExp RRB
	| NUMCONST
	| FLOATCONST
	| call
	| ID
	| ID LSB numSimpleExp RSB
	| LRB INT RRB boolSimpleExp
	| LRB INT RRB charSimpleExp
	| LRB INT RRB numSimpleExp
	| LRB FLOAT RRB numSimpleExp;

call : ID LRB args RRB;

args : simpleExp (COMA simpleExp)* | ;

mutable : ID
	| ID LSB numSimpleExp RSB;

charSimpleExp : CHARCONST
	| ID
	| ID LSB numSimpleExp RSB
	| LRB CHAR RRB numSimpleExp;

assignExp : mutable ASSIGN mutable
        | mutable ASSIGN call
        | mutable ASSIGN numSimpleExp
        | mutable ASSIGN charSimpleExp
        | mutable ASSIGN boolSimpleExp;