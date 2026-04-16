package algoritmos;

import grafos.BaseGrafo;

public class Backtracking {

    // aquí guardamos el mejor coste que encontremos
    private int mejorCoste;

    // guardamos el mejor camino encontrado
    private int[] mejorCamino;

    // array para saber qué nodos ya han sido visitados
    private boolean[] visitado;

    // camino que estamos construyendo en ese momento
    private int[] caminoActual;

    // numero de vertices del grafo
    private int V;

    public int solve(BaseGrafo G) {
        this.V = G.V;

        // inicialización de estructuras
        mejorCoste = BaseGrafo.INF;
        mejorCamino = new int[V + 1];
        visitado = new boolean[V];
        caminoActual = new int[V + 1];

    
        Runtime rt = Runtime.getRuntime();
        long usada = rt.totalMemory() - rt.freeMemory();
        System.out.println("RAM tras crear estructuras (Backtracking): " + (usada / (1024 * 1024)) + " MB");
      
        // empezamos en el nodo 0
        visitado[0] = true;
        caminoActual[0] = 0;

        backtracking(G, 0, 1, 0);

        if (mejorCoste >= BaseGrafo.INF) {
            System.out.println("Resultado: El grafo es imposible de resolver (No existe ciclo Hamiltoniano).");
            return -1;
        }

        // Mostrar resultados
        System.out.print("Mejor camino: ");
        for (int i = 0; i <= V; i++) {
            System.out.print(mejorCamino[i]);
            if (i < V) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

        return mejorCoste;
    }

    private void backtracking(BaseGrafo G, int nodoActual, int nivel, int costeActual) {

        // si el coste que llevamos ya es peor que el mejor, no tiene sentido seguir
        if (costeActual >= mejorCoste) {
            return;
        }

        // si ya hemos visitado todos los nodos
        if (nivel == V) {

            // miramos si desde el ultimo nodo podemos volver al nodo inicial
            if (G.edge[nodoActual][0] != BaseGrafo.INF) {
                int costeTotal = costeActual + G.edge[nodoActual][0];

                // si este camino completo es mejor que el anterior, lo guardamos
                if (costeTotal < mejorCoste) {
                    mejorCoste = costeTotal;

                    // copiamos el camino actual al mejor camino
                    for (int i = 0; i < V; i++) {
                        mejorCamino[i] = caminoActual[i];
                    }

                    // cerramos el ciclo volviendo al nodo 0
                    mejorCamino[V] = 0;
                }
            }
            return;
        }

        // recorremos posibles siguientes nodos
        for (int siguiente = 1; siguiente < V; siguiente++) {

            // solo seguimos si ese nodo no fue visitado y si existe arista entre nodoActual y siguiente
            if (!visitado[siguiente] && G.edge[nodoActual][siguiente] != BaseGrafo.INF) {

                // marcamos el nodo como visitado
                visitado[siguiente] = true;

                // lo añadimos al camino actual
                caminoActual[nivel] = siguiente;

                // llamada recursiva: seguimos construyendo el camino
                backtracking(G, siguiente, nivel + 1, costeActual + G.edge[nodoActual][siguiente]);

                // BACKTRACK:
                // desmarcamos el nodo para probar otras posibilidades
                visitado[siguiente] = false;
            }
        }
    }
}