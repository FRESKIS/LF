import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class DFABuilder extends DFAGrammarBaseVisitor<DFA> {

    DFA dfa;

    @Override
    public DFA visitDfa(DFAGrammarParser.DfaContext ctx) {
        dfa = visitStates(ctx.states());
        visitTransitions(ctx.transitions());
        visitIniState(ctx.iniState());
        visitFinalStates(ctx.finalStates());
        return dfa;
    }

    @Override
    public DFA visitStates(DFAGrammarParser.StatesContext ctx) {
        List<TerminalNode> states = ctx.ID();
        int numberOfStates = states.size();
        String[] stateList = new String[numberOfStates];
        int index = 0;
        for (TerminalNode state : states) {
            stateList[index++] = state.getText();
        }
        dfa = new DFA(stateList);
        return dfa;
    }

    @Override
    public DFA visitTransitions(DFAGrammarParser.TransitionsContext ctx) {
        List<DFAGrammarParser.TransitionContext> transitions = ctx.transition();
        for (DFAGrammarParser.TransitionContext transitionCtx : transitions) {
            visitTransition(transitionCtx);
        }
        return dfa;
    }

    @Override
    public DFA visitTransition(DFAGrammarParser.TransitionContext ctx) {
        String currentState = ctx.ID(0).toString();
        String nextState = ctx.ID(1).toString();
        char label = ctx.CHAR().toString().charAt(0);
        dfa.addTransition(currentState, label, nextState);
        return dfa;
    }

    @Override
    public DFA visitFinalStates(DFAGrammarParser.FinalStatesContext ctx) {
        List<TerminalNode> finalStates = ctx.ID();
        for (TerminalNode s : finalStates) {
            dfa.addFinalState(s.getText());
        }
        return dfa;
    }

    @Override
    public DFA visitIniState(DFAGrammarParser.IniStateContext ctx) {
        dfa.setInitialState(ctx.ID().getText());
        return dfa;
    }

    @Override
    public DFA visitErrorNode(ErrorNode node) {
        throw new RuntimeException("Compilation error " + node.getText());
    }

}
