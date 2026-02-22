// Generated from src/main/resources/DFAGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DFAGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DFAGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DFAGrammarParser#dfa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDfa(DFAGrammarParser.DfaContext ctx);
	/**
	 * Visit a parse tree produced by {@link DFAGrammarParser#states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStates(DFAGrammarParser.StatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DFAGrammarParser#transitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitions(DFAGrammarParser.TransitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DFAGrammarParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(DFAGrammarParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DFAGrammarParser#iniState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniState(DFAGrammarParser.IniStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DFAGrammarParser#finalStates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalStates(DFAGrammarParser.FinalStatesContext ctx);
}