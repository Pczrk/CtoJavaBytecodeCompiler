lexer grammar MyLexer;

// KEYWORDS:
FOR             : 'for';
WHILE           : 'while';
RETURN          : 'return';
BREAK           : 'break';
IF              : 'if';
ELSE            : 'else';
PRINTF          : 'print';

TRUE            : 'true';
FALSE           : 'false';

// LOGICAL OPERATORS:
AND             : '&&';
OR              : '||';
NOT             : '!';

// OPERATORS:
ASSIGN          : '=';
INCREASE        : '+=';
DECREASE        : '-=';
SELFMULTIPLY    : '*=';
SELFDIVIDE      : '/=';
EQUAL           : '==';
NOT_EQUAL       : '!=';
LESS            : '<';
GREATER         : '>';
LESS_EQUAL      : '<=';
GREATER_EQUAL   : '>=';
PLUS            : '+';
MINUS           : '-';
MULTIPLY        : '*';
DIVIDE          : '/';
COLON           : ':';
SEMICOLON       : ';';
COMA       	: ',';

// BRACKETS:
LRB             : '(';
RRB             : ')';
LCB             : '{';
RCB             : '}';
LSB             : '[';
RSB             : ']';

// TYPES:
VOID            : 'void';
FLOAT            : 'float';
INT             : 'int';
CHAR            : 'char';
BOOL            : 'bool';


// CONSTANT:
FLOATCONST	    : [0-9]+ '.' [0-9]+;
NUMCONST        : [0-9]+;
CHARCONST       : '\''[a-zA-Z ]'\''
                | '\'''\\''n''\''
                | '\'''\\''t''\'';
STRINGCONST     : '"'[a-zA-Z]+'"';

// IDENTIFIER:
ID              : [a-zA-Z_][a-zA-Z0-9_]*;

// WHITESPACE:
WHITESPACE      : [ \t\r\n]+ -> skip;
