lexer grammar Lexer;

// KEYWORDS:
FOR             : 'for';
WHILE           : 'while';
RETURN          : 'return';
BREAK           : 'break';
IF              : 'if';
ELSE            : 'else';
PRINTF          : 'printf';

// OPERATORS:
ASSIGN          : '=';
INCREASE        : '+=';
DESCRESE        : '-=';
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

// BRACKETS:
LRB             : '(';
RRB             : ')';
LCB             : '{';
RCB             : '}';
LSB             : '[';
RSB             : ']';

// TYPES:
VOID            : 'void';
INT             : 'int';
CHAR            : 'char';
BOOL            : 'bool';

// IDENTIFIER:
ID              : [a-zA-Z_][a-zA-Z0-9_]*;

// CONSTANT:
NUMCONST        : [0-9]+;
CHARCONST       : '\''[a-zA-Z]'\'';
STRINGCONST     : '"'[a-zA-Z]+'"';
TRUE            : 'true';
FALSE           : 'false';

// LOGICAL OPERATORS:
AND             : '&&';
OR              : '||';
NOT             : '!';

// WHITESPACE:
WHITESPACE      : [ \t\r\n]+ -> skip;
