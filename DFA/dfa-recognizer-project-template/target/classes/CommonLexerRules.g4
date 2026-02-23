lexer grammar CommonLExerRules; // note "lexer grammar"

CHAR  : (LETTER | DIGIT) ;    // match identifiers
ID  : (LETTER | DIGIT)+ ;    // match identifiers
LETTER: [a-zA-Z]+;  // match a letter
INT : (DIGIT)+ ;    // match integers
DIGIT : [0-9] ; // match a digit
WS  : [ \t\r\n]+ -> skip ;  // toss out whitespace

BLOCK_COMMENT: '/*' .*? '*/' -> skip;
