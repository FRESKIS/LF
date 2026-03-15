import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*For simplicity, this  class does not allow for the construction of a regular expression
* that accepts the empty sequence. The reason being that we have no symbol to
* denote the empty sequence.
*/
public class RegularExpression {

    private static int contadorEstados = 0;

    private final NFA automata;

    public RegularExpression(NFA engine, String re) {
        this.automata = engine;
    }

    /*RE vacía*/
    public RegularExpression() {
        String inicio = nuevoEstado();
        String fin = nuevoEstado();

        NFA nfa = new NFA(new String[]{inicio, fin});
        nfa.setInitialState(inicio);

        this.automata = nfa;
    }

    /* RE de 1 solo carácter*/
    public RegularExpression(char a) {
        String inicio = nuevoEstado();
        String fin = nuevoEstado();

        NFA nfa = new NFA(new String[]{inicio, fin});
        nfa.setInitialState(inicio);
        nfa.addFinalState(fin);
        nfa.addTransition(inicio, a, fin);

        this.automata = nfa;
    }

    public RegularExpression(char[] chard) {
        RegularExpression union = crearUnionDeCaracteres(chard);
        this.automata = union.automata;
    }

    public RegularExpression(char ini, char end) {
        if (ini > end) {
            throw new IllegalArgumentException("Rango incorrecto");
        }

        char[] letras = new char[end - ini + 1];
        for (int i = 0; i < letras.length; i++) {
            letras[i] = (char) (ini + i);
        }

        RegularExpression union = crearUnionDeCaracteres(letras);
        this.automata = union.automata;
    }

    public static RegularExpression createUnionRE(RegularExpression left, RegularExpression right) {
        CopiaNFA copiaIzquierda = copiarNFA(left.automata);
        CopiaNFA copiaDerecha = copiarNFA(right.automata);

        String inicio = nuevoEstado();
        String fin = nuevoEstado();

        String[] estados = juntarArrays(
            new String[]{inicio, fin},
            copiaIzquierda.estados,
            copiaDerecha.estados
        );

        NFA nfa = new NFA(estados);
        nfa.setInitialState(inicio);
        nfa.addFinalState(fin);

        ponerTransiciones(nfa, copiaIzquierda);
        ponerTransiciones(nfa, copiaDerecha);

        nfa.addEpsilonTransition(inicio, copiaIzquierda.inicial);
        nfa.addEpsilonTransition(inicio, copiaDerecha.inicial);

        for (String estadoFinal : copiaIzquierda.finales) {
            nfa.addEpsilonTransition(estadoFinal, fin);
        }

        for (String estadoFinal : copiaDerecha.finales) {
            nfa.addEpsilonTransition(estadoFinal, fin);
        }

        return new RegularExpression(nfa, "");
    }

    public static RegularExpression createSequentialRE(RegularExpression[] res) {
        if (res == null || res.length == 0) {
            return new RegularExpression();
        }

        RegularExpression resultado = res[0];
        for (int i = 1; i < res.length; i++) {
            resultado = concatenar(resultado, res[i]);
        }

        return resultado;
    }

    public static RegularExpression createStartRE(RegularExpression re) {
        CopiaNFA copia = copiarNFA(re.automata);

        String inicio = nuevoEstado();
        String fin = nuevoEstado();
        String[] estados = juntarArrays(new String[]{inicio, fin}, copia.estados);

        NFA nfa = new NFA(estados);
        nfa.setInitialState(inicio);
        nfa.addFinalState(fin);

        ponerTransiciones(nfa, copia);

        nfa.addEpsilonTransition(inicio, copia.inicial);
        nfa.addEpsilonTransition(inicio, fin);

        for (String estadoFinal : copia.finales) {
            nfa.addEpsilonTransition(estadoFinal, copia.inicial);
            nfa.addEpsilonTransition(estadoFinal, fin);
        }

        return new RegularExpression(nfa, "");
    }

    public static RegularExpression createUnionRE(RegularExpression[] disj) {
        if (disj == null || disj.length == 0) {
            return new RegularExpression();
        }

        RegularExpression resultado = disj[0];
        for (int i = 1; i < disj.length; i++) {
            resultado = createUnionRE(resultado, disj[i]);
        }

        return resultado;
    }

    public Boolean accept(String string) {
        if (string.isEmpty()) {
            return false;
        }
        return automata.accept(string);
    }

    private static RegularExpression concatenar(RegularExpression izquierda, RegularExpression derecha) {
        CopiaNFA copiaIzquierda = copiarNFA(izquierda.automata);
        CopiaNFA copiaDerecha = copiarNFA(derecha.automata);

        String[] estados = juntarArrays(copiaIzquierda.estados, copiaDerecha.estados);

        NFA nfa = new NFA(estados);
        nfa.setInitialState(copiaIzquierda.inicial);

        ponerTransiciones(nfa, copiaIzquierda);
        ponerTransiciones(nfa, copiaDerecha);

        for (String estadoFinal : copiaIzquierda.finales) {
            nfa.addEpsilonTransition(estadoFinal, copiaDerecha.inicial);
        }

        for (String estadoFinal : copiaDerecha.finales) {
            nfa.addFinalState(estadoFinal);
        }

        return new RegularExpression(nfa, "");
    }

    private static RegularExpression crearUnionDeCaracteres(char[] caracteres) {
        if (caracteres == null || caracteres.length == 0) {
            return new RegularExpression();
        }

        RegularExpression[] expresiones = new RegularExpression[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            expresiones[i] = new RegularExpression(caracteres[i]);
        }

        return createUnionRE(expresiones);
    }

    private static CopiaNFA copiarNFA(NFA original) {
        Map<String, String> cambioNombres = new HashMap<>();
        Set<String> estadosOriginales = original.getStates();
        String[] estadosNuevos = new String[estadosOriginales.size()];

        int i = 0;
        for (String estado : estadosOriginales) {
            String nuevo = nuevoEstado();
            cambioNombres.put(estado, nuevo);
            estadosNuevos[i++] = nuevo;
        }

        CopiaNFA copia = new CopiaNFA();
        copia.estados = estadosNuevos;
        copia.inicial = cambioNombres.get(original.getInitialState());
        copia.finales = new HashSet<>();
        copia.transiciones = new ArrayList<>();
        copia.transicionesVacias = new ArrayList<>();

        for (String estadoFinal : original.getFinalStates()) {
            copia.finales.add(cambioNombres.get(estadoFinal));
        }

        Map<String, Map<Label, Set<String>>> transiciones = original.getTransitions();
        for (String origen : transiciones.keySet()) {
            Map<Label, Set<String>> mapaInterior = transiciones.get(origen);
            for (Label etiqueta : mapaInterior.keySet()) {
                for (String destino : mapaInterior.get(etiqueta)) {
                    copia.transiciones.add(
                        new Paso(
                            cambioNombres.get(origen),
                            etiqueta.getValue(),
                            cambioNombres.get(destino)
                        )
                    );
                }
            }
        }

        Map<String, Set<String>> epsilons = original.getEpsilonTransitions();
        for (String origen : epsilons.keySet()) {
            for (String destino : epsilons.get(origen)) {
                copia.transicionesVacias.add(
                    new Paso(
                        cambioNombres.get(origen),
                        null,
                        cambioNombres.get(destino)
                    )
                );
            }
        }

        return copia;
    }

    private static void ponerTransiciones(NFA destino, CopiaNFA copia) {
        for (Paso paso : copia.transiciones) {
            destino.addTransition(paso.origen, paso.simbolo, paso.destino);
        }

        for (Paso paso : copia.transicionesVacias) {
            destino.addEpsilonTransition(paso.origen, paso.destino);
        }
    }

    private static String[] juntarArrays(String[]... arrays) {
        int total = 0;
        for (String[] array : arrays) {
            total += array.length;
        }

        String[] resultado = new String[total];
        int indice = 0;

        for (String[] array : arrays) {
            for (String valor : array) {
                resultado[indice++] = valor;
            }
        }

        return resultado;
    }

    private static String nuevoEstado() {
        return "q" + contadorEstados++;
    }

    private static class Paso {
        String origen;
        Character simbolo;
        String destino;

        Paso(String origen, Character simbolo, String destino) {
            this.origen = origen;
            this.simbolo = simbolo;
            this.destino = destino;
        }
    }

    private static class CopiaNFA {
        String[] estados;
        String inicial;
        Set<String> finales;
        List<Paso> transiciones;
        List<Paso> transicionesVacias;
    }
}
