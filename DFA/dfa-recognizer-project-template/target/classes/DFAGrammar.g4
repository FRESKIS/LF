grammar DFAGrammar;
import CommonLexerRules;  // includes all rules from CommonLexerRule.g4

/* Beging parsing here. */
dfa: 
    states  
    transitions  
    iniState 
    finalStates;  

states: 'states' '=' '{' ID (',' ID)*'}';    

transitions: 'transitions' '=' '{' (transition (',' transition)*)?'}';   

transition: '(' ID ',' CHAR ',' ID ')'; 

iniState: 'ini' '=' ID; 

finalStates: 'finals' '=' '{' ID (',' ID)*'}';    

