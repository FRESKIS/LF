import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class NFABuilder extends NFAGrammarBaseVisitor<NFA> {

    NFA nfa;

    @Override
    public NFA visitNfa(NFAGrammarParser.NfaContext ctx) {
        nfa = visitStates(ctx.states());
        visitTransitions(ctx.transitions());
        visitIniState(ctx.iniState());
        visitFinalStates(ctx.finalStates());
        return nfa;
    }

    @Override
    public NFA visitStates(NFAGrammarParser.StatesContext ctx) {
        List<TerminalNode> states = ctx.ID();
        int numberOfStates = states.size();
        String[] stateList = new String[numberOfStates];
        int index = 0;
        for (TerminalNode state : states) {
            stateList[index++] = state.getText();
        }
        nfa = new NFA(stateList);
        return nfa;
    }

    @Override
    public NFA visitTransitions(NFAGrammarParser.TransitionsContext ctx) {
        List<NFAGrammarParser.TransitionContext> transitions = ctx.transition();
        for (NFAGrammarParser.TransitionContext transitionCtx : transitions) {
            visitTransition(transitionCtx);
        }
        return nfa;
    }

    @Override
    public NFA visitTransition(NFAGrammarParser.TransitionContext ctx) {
        String currentState = ctx.ID(0).toString();
        String nextState = ctx.ID(1).toString();
        if (ctx.CHAR() != null){
            char label = ctx.CHAR().toString().charAt(0);
            nfa.addTransition(currentState, label, nextState);
        }
        else {
            nfa.addEpsilonTransition(currentState, nextState);            
        }
        return nfa;
    }

    @Override
    public NFA visitFinalStates(NFAGrammarParser.FinalStatesContext ctx) {
        List<TerminalNode> finalStates = ctx.ID();
        for (TerminalNode s : finalStates) {
            nfa.addFinalState(s.getText());
        }
        return nfa;
    }

    @Override
    public NFA visitIniState(NFAGrammarParser.IniStateContext ctx) {
        nfa.setInitialState(ctx.ID().getText());
        return nfa;
    }

    @Override
    public NFA visitErrorNode(ErrorNode node) {
        throw new RuntimeException("Compilation error " + node.getText());
    }

}
