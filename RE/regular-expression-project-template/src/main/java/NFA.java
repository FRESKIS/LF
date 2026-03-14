import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NFA {

    // --- Atributs Privats per gestionar l'estat ---
    private final Set<String> states;
    private final Set<String> finalStates;
    private String initialState;

    // Mapa principal: Estat -> (Label -> Conjunt de destins)
    private final Map<String, Map<Label, Set<String>>> transitions;

    // Mapa separat per a transicions epsilon per eficiència
    private final Map<String, Set<String>> epsilons;

    // --- Constructor ---
    public NFA(String[] states) {
        if (states == null || states.length == 0) {
            throw new IllegalArgumentException("Cal almenys un estat per crear l'NFA.");
        }

        this.states = new HashSet<>(Arrays.asList(states));
        this.finalStates = new HashSet<>();
        this.transitions = new HashMap<>();
        this.epsilons = new HashMap<>();

        for (String s : this.states) {
            transitions.put(s, new HashMap<>());
            epsilons.put(s, new HashSet<>());
        }
    }

    // --- Mètodes de Configuració ---

    public void setInitialState(String state) {
        if (!states.contains(state)) {
            throw new IllegalArgumentException("L'estat '" + state + "' no existeix.");
        }
        this.initialState = state;
    }

    public String getInitialState() {
        return initialState;
    }

    public void addFinalState(String state) {
        if (!states.contains(state)) {
            throw new IllegalArgumentException("L'estat '" + state + "' no existeix.");
        }
        finalStates.add(state);
    }

    // Method to add a transition to the table
    public void addTransition(String state, Character input, String nextState) {
        if (!states.contains(state) || !states.contains(nextState)) {
            throw new IllegalArgumentException("Estats no vàlids.");
        }
        if (input == null) {
            throw new IllegalArgumentException("Per transicions buides usa addEpsilonTransition.");
        }

        Label label = Label.createNonEmptyLabel(input);
        transitions.get(state)
                   .computeIfAbsent(label, k -> new HashSet<>())
                   .add(nextState);
    }

    public void addEpsilonTransition(String state, String nextState) {
        if (!states.contains(state) || !states.contains(nextState)) {
            throw new IllegalArgumentException("Estats no vàlids.");
        }
        epsilons.get(state).add(nextState);
    }

    // --- Getters de lectura per combinar autòmats ---

    public Set<String> getStates() {
        return new HashSet<>(states);
    }

    public Set<String> getFinalStates() {
        return new HashSet<>(finalStates);
    }

    public Map<String, Map<Label, Set<String>>> getTransitions() {
        Map<String, Map<Label, Set<String>>> copy = new HashMap<>();
        for (Map.Entry<String, Map<Label, Set<String>>> entry : transitions.entrySet()) {
            Map<Label, Set<String>> innerCopy = new HashMap<>();
            for (Map.Entry<Label, Set<String>> inner : entry.getValue().entrySet()) {
                innerCopy.put(inner.getKey(), new HashSet<>(inner.getValue()));
            }
            copy.put(entry.getKey(), innerCopy);
        }
        return copy;
    }

    public Map<String, Set<String>> getEpsilonTransitions() {
        Map<String, Set<String>> copy = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : epsilons.entrySet()) {
            copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
        return copy;
    }

    // --- Lògica d'Acceptació ---

    public boolean accept(String input) {
        return NFAtoDFA().accept(input);
    }

    public Set<Label> getAllLabels() {
        Set<Label> labels = new HashSet<>();
        for (Map<Label, Set<String>> map : transitions.values()) {
            labels.addAll(map.keySet());
        }
        return labels;
    }

    // --- CORE: Conversió NFA a DFA (Subset Construction) ---

    public DFA NFAtoDFA() {
        if (initialState == null) {
            throw new IllegalStateException("Estat inicial no definit.");
        }

        Set<Character> alphabet = new HashSet<>();
        for (Label l : getAllLabels()) {
            if (!l.isEmptyTransition()) {
                alphabet.add(l.getValue());
            }
        }

        Map<Set<String>, String> subsetsProcessed = new HashMap<>();
        Queue<Set<String>> queue = new ArrayDeque<>();

        List<String> dfaStatesList = new ArrayList<>();
        List<String> dfaFinalsList = new ArrayList<>();
        List<String[]> dfaTransitionsList = new ArrayList<>();

        Set<String> startSubset = epsilonClosure(Collections.singleton(initialState));
        String startName = canonName(startSubset);

        subsetsProcessed.put(startSubset, startName);
        queue.add(startSubset);
        dfaStatesList.add(startName);

        while (!queue.isEmpty()) {
            Set<String> currentSubset = queue.poll();
            String currentDfaName = subsetsProcessed.get(currentSubset);

            if (!Collections.disjoint(currentSubset, finalStates)) {
                dfaFinalsList.add(currentDfaName);
            }

            for (char symbol : alphabet) {
                Set<String> moveTargets = new HashSet<>();
                for (String nfaState : currentSubset) {
                    Map<Label, Set<String>> transMap = transitions.get(nfaState);
                    if (transMap != null) {
                        for (Map.Entry<Label, Set<String>> entry : transMap.entrySet()) {
                            Label l = entry.getKey();
                            if (!l.isEmptyTransition() && l.getValue() == symbol) {
                                moveTargets.addAll(entry.getValue());
                            }
                        }
                    }
                }

                if (!moveTargets.isEmpty()) {
                    Set<String> nextSubset = epsilonClosure(moveTargets);

                    String nextDfaName = subsetsProcessed.get(nextSubset);
                    if (nextDfaName == null) {
                        nextDfaName = canonName(nextSubset);
                        subsetsProcessed.put(nextSubset, nextDfaName);
                        queue.add(nextSubset);
                        dfaStatesList.add(nextDfaName);
                    }

                    dfaTransitionsList.add(new String[]{currentDfaName, String.valueOf(symbol), nextDfaName});
                }
            }
        }

        DFA dfa = new DFA(dfaStatesList.toArray(new String[0]));
        dfa.setInitialState(startName);

        for (String f : dfaFinalsList) {
            dfa.addFinalState(f);
        }

        for (String[] t : dfaTransitionsList) {
            dfa.addTransition(t[0], t[1].charAt(0), t[2]);
        }

        return dfa;
    }

    // --- MÈTODES PRIVATS (Helpers necessaris) ---

    private Set<String> epsilonClosure(Set<String> startStates) {
        Set<String> closure = new HashSet<>(startStates);
        Deque<String> stack = new ArrayDeque<>(startStates);

        while (!stack.isEmpty()) {
            String u = stack.pop();
            Set<String> targets = epsilons.get(u);
            if (targets != null) {
                for (String v : targets) {
                    if (closure.add(v)) {
                        stack.push(v);
                    }
                }
            }
        }
        return closure;
    }

    private String canonName(Set<String> subset) {
        if (subset.isEmpty()) return "DEAD_STATE";
        List<String> sorted = new ArrayList<>(subset);
        Collections.sort(sorted);
        return "{" + String.join(",", sorted) + "}";
    }
}