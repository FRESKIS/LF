grammar REGrammar;

import CommonLexerRules;  // includes all rules from CommonLexerRule.g4


epsilon:
	'epsilon' //just means it 's ok to match an empty string when no better option is available. 
	;

regular_expression:
	alternation_expression regular_expression
	| epsilon
	;

alternation_expression:
	'|' alternation_expression_rest
	| concatenation_expression alternation_expression_rest
	;

alternation_expression_rest:
	'|' concatenation_expression alternation_expression_rest
	| '|' alternation_expression_rest
	;

concatenation_expression:
	quantified_expression concatenation_expression_rest
	;

concatenation_expression_rest:
	quantified_expression concatenation_expression_rest
	| epsilon
	;

quantified_expression:
	character_or_class quantifier_operator
	| character_or_class
	| sub_expression quantifier_operator
	| sub_expression
	| anchor
	;

sub_expression:
	'(' regular_expression ')' 	// Technically supported by doing nothing since back -references are
								//not implemented yet .
	;

character_or_class: 
	character_class 
	| non_class_character
	;

quantifier_operator:
	| implicit_quantifier
	;

implicit_quantifier: 
	'+' | '*';