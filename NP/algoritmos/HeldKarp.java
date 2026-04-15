package algoritmos;

import grafos.BaseGrafo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeldKarp {
    // memo[mask][pos] guarda el costo mínimo para visitar las ciudades en 'mask'
    // terminando en la ciudad 'pos'.
    private int[][] memo;
    
    // parent[mask][pos] guarda cuál fue la ciudad 'i' que elegimos para obtener
    // ese costo mínimo. Usamos byte para ahorrar 75% de RAM en esta tabla.
    private byte[][] parent; 
    
    private int V;

    public int solve(BaseGrafo G) {
        this.V = G.V;
        
        // El número de estados es 2^V (todas las combinaciones de ciudades visitadas)
        // por V (la ciudad donde estamos parados actualmente).
        memo = new int[1 << V][V];
        parent = new byte[1 << V][V];

        Runtime rt = Runtime.getRuntime();
        long usada = rt.totalMemory() - rt.freeMemory();
        System.out.println("RAM tras crear matrices: " + (usada / (1024 * 1024)) + " MB");

        // Inicializamos memo con -1 (no calculado) y parent con -1 (sin camino)
        for (int[] row : memo) Arrays.fill(row, -1);
        for (byte[] row : parent) Arrays.fill(row, (byte) -1);

        // El bitmask '1' significa que ya visitamos la ciudad 0 (binario: 000...0001)
        int resultado = tsp(1, 0, G);

        if (resultado >= BaseGrafo.INF) {
            System.out.println("Resultado: No existe un ciclo Hamiltoniano (camino infinito).");
            return -1; 
        }

        // Una vez terminada la recursión, reconstruimos la ruta usando la tabla parent
        imprimirCamino();

        return resultado;
    }

    private int tsp(int mask, int pos, BaseGrafo G) {
        // CASO BASE: Si la máscara tiene todos los bits en 1, visitamos todo.
        if (mask == (1 << V) - 1) {
            // Retornamos el costo de volver desde la última ciudad 'pos' al origen '0'
            return G.edge[pos][0]; 
        }

        // Si ya calculamos este estado, lo devolvemos inmediatamente (Memoización)
        if (memo[mask][pos] != -1) {
            return memo[mask][pos];
        }

        int res = BaseGrafo.INF;
        int mejorSiguiente = -1;

        // Intentamos movernos a cualquier ciudad 'i' que no haya sido visitada
        for (int i = 0; i < V; i++) {
            // Verificamos: 1. El bit 'i' es 0 (no visitada) y 2. Hay conexión física
            if ((mask & (1 << i)) == 0 && G.edge[pos][i] != BaseGrafo.INF) {
                
                // Calculamos el costo de ir a 'i' + el costo óptimo del resto del camino
                int nuevoCosto = G.edge[pos][i] + tsp(mask | (1 << i), i, G);
                
                // Si este camino es mejor que el que conocíamos, lo guardamos
                if (nuevoCosto < res) {
                    res = nuevoCosto;
                    mejorSiguiente = i; 
                }
            }
        }

        // Guardamos la decisión (índice de la ciudad i) para reconstruir el camino luego
        parent[mask][pos] = (byte) mejorSiguiente;
        
        // Guardamos el costo en memo para no repetirlo
        return memo[mask][pos] = res;
    }

    private void imprimirCamino() {
        List<Integer> camino = new ArrayList<>();
        int mask = 1; // Empezamos sabiendo que visitamos la ciudad 0
        int pos = 0;  // Estamos parados en la ciudad 0

        camino.add(0);

        // Seguimos el "rastro de migas de pan" que dejamos en la tabla parent
        while (true) {
            int siguiente = parent[mask][pos];
            
            // Si llegamos a -1, significa que no hay más nodos que visitar
            if (siguiente == -1) break; 
            
            camino.add(siguiente);
            
            // Actualizamos el estado para la siguiente iteración:
            // Marcamos el siguiente nodo como visitado en la máscara
            mask = mask | (1 << siguiente);
            // Nos movemos físicamente a ese nodo
            pos = siguiente;
        }

        camino.add(0); // Cerramos el ciclo volviendo al inicio

        // Construcción estética de la cadena de texto
        StringBuilder sb = new StringBuilder();
        sb.append("camino escogido:   ");
        for (int i = 0; i < camino.size(); i++) {
            sb.append(camino.get(i));
            if (i < camino.size() - 1) sb.append(" -> ");
        }
        System.out.println(sb.toString());
    }
}