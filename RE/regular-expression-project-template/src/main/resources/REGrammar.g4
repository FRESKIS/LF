grammar REGrammar;

// Entry rule: alternation (|)
expr:	term ('|' term)* #ExprRE; // Handles "a|b"

// Concatenation (sequential elements)
term:	factor factor* #TermRE; // Ensures left-to-right parsing

// Single unit with optional repetition (*)
factor:	base '*'? # FactorRE; // Ensures * applies only to the previous base

// Defines a valid base element
base:
	CHAR # CharRE // Matches a single character
	| charClass # CharClassRE // Matches a character class like [a-z]
	| '(' expr ')' # ParenthesesRE ; // Parentheses for grouping

// Character class, supporting ranges and individual characters
charClass:	'[' CHAR '-' CHAR ']' #CharRangeRE ; // Matches [a-z], [abc], [0-9A-Z]

// Tokens
CHAR: [a-zA-Z0-9]; // Matches a single alphanumeric character

WS: [ \t\r\n]+ -> skip; // Ignore whitespace

BLOCK_COMMENT: '/*' .*? '*/' -> skip;