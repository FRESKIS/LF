// Generated from c:/Users/rolan/Documents/Work/academic-duties/teaching/2026/Formal-languages/code/task4-regular-expression-mysolution/src/main/resources/REGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link REGrammarParser}.
 */
public interface REGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ExprRE}
	 * labeled alternative in {@link REGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRE(REGrammarParser.ExprREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRE}
	 * labeled alternative in {@link REGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRE(REGrammarParser.ExprREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermRE}
	 * labeled alternative in {@link REGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermRE(REGrammarParser.TermREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermRE}
	 * labeled alternative in {@link REGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermRE(REGrammarParser.TermREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorRE}
	 * labeled alternative in {@link REGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorRE(REGrammarParser.FactorREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorRE}
	 * labeled alternative in {@link REGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorRE(REGrammarParser.FactorREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void enterCharRE(REGrammarParser.CharREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void exitCharRE(REGrammarParser.CharREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharClassRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void enterCharClassRE(REGrammarParser.CharClassREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharClassRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void exitCharClassRE(REGrammarParser.CharClassREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesesRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesRE(REGrammarParser.ParenthesesREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesesRE}
	 * labeled alternative in {@link REGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesRE(REGrammarParser.ParenthesesREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharRangeRE}
	 * labeled alternative in {@link REGrammarParser#charClass}.
	 * @param ctx the parse tree
	 */
	void enterCharRangeRE(REGrammarParser.CharRangeREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharRangeRE}
	 * labeled alternative in {@link REGrammarParser#charClass}.
	 * @param ctx the parse tree
	 */
	void exitCharRangeRE(REGrammarParser.CharRangeREContext ctx);
}