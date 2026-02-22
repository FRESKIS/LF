// Generated from NFAGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NFAGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NFAGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NFAGrammarParser#nfa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNfa(NFAGrammarParser.NfaContext ctx);
	/**
	 * Visit a parse tree produced by {@link NFAGrammarParser#states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStates(NFAGrammarParser.StatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link NFAGrammarParser#transitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitions(NFAGrammarParser.TransitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NFAGrammarParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(NFAGrammarParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NFAGrammarParser#iniState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniState(NFAGrammarParser.IniStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link NFAGrammarParser#finalStates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalStates(NFAGrammarParser.FinalStatesContext ctx);
}