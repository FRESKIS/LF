package algoritmos;

import grafos.BaseGrafo;
import java.util.Arrays;

public class HeldKarp {
    private int[][] memo;
    private int V;

    public int solve(BaseGrafo G) {
        this.V = G.V;
        // La tabla tiene 2^V estados posibles (máscara de bits) por cada ciudad
        // Usamos (1 << V) para calcular 2 elevado a la V
        memo = new int[1 << V][V];

        // Inicializamos la tabla con -1 para indicar que no se ha calculado nada
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Empezamos en la ciudad 0, con la máscara de visitados en 1 (solo ciudad 0)
        int resultado = tsp(1, 0, G);

        // COMPROBACIÓN: Si el resultado es >= INF, el grafo no tiene solución
        if (resultado >= BaseGrafo.INF) {
            System.out.println("Resultado: El grafo es imposible de resolver (No existe ciclo Hamiltoniano).");
            return -1; 
        }

        return resultado;
    }

    private int tsp(int mask, int pos, BaseGrafo G) {
        // CASO BASE: Si todos los bits son 1, hemos visitado todas las ciudades
        if (mask == (1 << V) - 1) {
            // Intentamos volver al origen (0)
            return G.edge[pos][0]; 
        }

        // Si ya calculamos este estado antes, lo devolvemos (Memoización)
        if (memo[mask][pos] != -1) {
            return memo[mask][pos];
        }

        int res = BaseGrafo.INF;

        // Intentamos ir a cada ciudad 'i'
        for (int i = 0; i < V; i++) {
            // Si la ciudad 'i' no ha sido visitada (el bit 'i' en la máscara es 0)
            // Y existe un camino desde la posición actual a 'i'
            if ((mask & (1 << i)) == 0 && G.edge[pos][i] != BaseGrafo.INF) {
                
                int nuevoCosto = G.edge[pos][i] + tsp(mask | (1 << i), i, G);
                
                if (nuevoCosto < res) {
                    res = nuevoCosto;
                }
            }
        }

        // Guardamos y devolvemos el resultado
        return memo[mask][pos] = res;
    }
}