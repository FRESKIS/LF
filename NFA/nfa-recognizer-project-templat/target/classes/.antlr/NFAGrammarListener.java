// Generated from c:/Users/rolan/Documents/Work/academic-duties/teaching/2026/Formal-languages/code/task3-nfa-recognizer-mysolution/src/main/resources/NFAGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NFAGrammarParser}.
 */
public interface NFAGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NFAGrammarParser#dfa}.
	 * @param ctx the parse tree
	 */
	void enterDfa(NFAGrammarParser.DfaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAGrammarParser#dfa}.
	 * @param ctx the parse tree
	 */
	void exitDfa(NFAGrammarParser.DfaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAGrammarParser#states}.
	 * @param ctx the parse tree
	 */
	void enterStates(NFAGrammarParser.StatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAGrammarParser#states}.
	 * @param ctx the parse tree
	 */
	void exitStates(NFAGrammarParser.StatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAGrammarParser#transitions}.
	 * @param ctx the parse tree
	 */
	void enterTransitions(NFAGrammarParser.TransitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAGrammarParser#transitions}.
	 * @param ctx the parse tree
	 */
	void exitTransitions(NFAGrammarParser.TransitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAGrammarParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(NFAGrammarParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAGrammarParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(NFAGrammarParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAGrammarParser#iniState}.
	 * @param ctx the parse tree
	 */
	void enterIniState(NFAGrammarParser.IniStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAGrammarParser#iniState}.
	 * @param ctx the parse tree
	 */
	void exitIniState(NFAGrammarParser.IniStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAGrammarParser#finalStates}.
	 * @param ctx the parse tree
	 */
	void enterFinalStates(NFAGrammarParser.FinalStatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAGrammarParser#finalStates}.
	 * @param ctx the parse tree
	 */
	void exitFinalStates(NFAGrammarParser.FinalStatesContext ctx);
}