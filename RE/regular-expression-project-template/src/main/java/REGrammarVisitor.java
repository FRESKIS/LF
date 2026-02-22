// Generated from REGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link REGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface REGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ExprRE}
	 * labeled alternative in {@link REGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRE(REGrammarParser.ExprREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermRE}
	 * labeled alternative in {@link REGrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermRE(REGrammarParser.TermREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorRE}
	 * labeled alternative in {@link REGrammarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorRE(REGrammarParser.FactorREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharRE(REGrammarParser.CharREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharClassRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharClassRE(REGrammarParser.CharClassREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesesRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesRE(REGrammarParser.ParenthesesREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharRangeRE}
	 * labeled alternative in {@link REGrammarParser#charClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharRangeRE(REGrammarParser.CharRangeREContext ctx);
}