

public class REBuilder extends REGrammarBaseVisitor<RegularExpression> {



    @Override
    public RegularExpression visitExprRE(REGrammarParser.ExprREContext ctx) {
        RegularExpression[] disj = new RegularExpression[ctx.term().size()];
        int index = 0;
        for (REGrammarParser.TermContext term : ctx.term()) {
            disj[index++] = visit(term);
        }
        return RegularExpression.createUnionRE(disj);
    }

    @Override
    public RegularExpression visitTermRE(REGrammarParser.TermREContext ctx) {
        RegularExpression[] sequence = new RegularExpression[ctx.factor().size()];
        int index = 0; 
        for (REGrammarParser.FactorContext factor : ctx.factor()){
            sequence[index++] = visit(factor);
        }
        return RegularExpression.createSequentialRE(sequence);
    }

    @Override
    public RegularExpression visitFactorRE(REGrammarParser.FactorREContext ctx) {
        RegularExpression re = visit(ctx.base());
        if (ctx.getChildCount() > 1)
            return RegularExpression.createStartRE(re);
        else return re; 
    }

    @Override
    public RegularExpression visitParenthesesRE(REGrammarParser.ParenthesesREContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public RegularExpression visitCharRangeRE(REGrammarParser.CharRangeREContext ctx) {
        char ini = ctx.CHAR(0).toString().toCharArray()[0];
        char end = ctx.CHAR(1).toString().toCharArray()[0];
        return new RegularExpression(ini, end);
    }

    @Override
    public RegularExpression visitCharRE(REGrammarParser.CharREContext ctx) {
        char c = ctx.CHAR().toString().toCharArray()[0];
        return new RegularExpression(c);
    }

}
