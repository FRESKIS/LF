package algoritmos;

import grafos.BaseGrafo;

public class FuerzaBruta {

    private int mejorCoste;
    private int[] mejorCamino;
    private int V;

    public int solve(BaseGrafo G) {
        this.V = G.V;
        
        // Inicializamos con un valor "infinito" usando la constante de BaseGrafo
        mejorCoste = BaseGrafo.INF;
        mejorCamino = new int[V + 1];

        // Creamos un arreglo con los nodos a permutar (todos menos el nodo 0 que es el inicio/fin)
        int[] nodos = new int[V - 1];
        for (int i = 0; i < V - 1; i++) {
            nodos[i] = i + 1;
        }

        // Generamos todas las permutaciones y evaluamos cada ruta
        generarPermutaciones(nodos, 0, G);

        // Si el costo sigue siendo INF, significa que ningún ciclo fue válido
        if (mejorCoste >= BaseGrafo.INF) {
            System.out.println("Resultado: El grafo es imposible de resolver (No existe ciclo Hamiltoniano).");
            return -1;
        }

        // Mostrar resultados en consola
        System.out.println("Mejor coste: " + mejorCoste);
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

    // Método para generar todas las permutaciones posibles usando recursividad
    private void generarPermutaciones(int[] arr, int k, BaseGrafo G) {
        if (k == arr.length) {
            // Cuando tenemos una permutación completa, evaluamos su costo
            evaluarRuta(arr, G);
        } else {
            for (int i = k; i < arr.length; i++) {
                intercambiar(arr, i, k);
                generarPermutaciones(arr, k + 1, G);
                intercambiar(arr, k, i); // Backtrack del intercambio
            }
        }
    }

    // Método auxiliar para intercambiar elementos en el arreglo
    private void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Método que calcula el peso de una permutación específica
    private void evaluarRuta(int[] arr, BaseGrafo G) {
        int costeActual = 0;
        int nodoActual = 0; // Siempre partimos del nodo 0

        // Recorremos los nodos en el orden de la permutación generada
        for (int i = 0; i < arr.length; i++) {
            int siguienteNodo = arr[i];
            int pesoArista = G.edge[nodoActual][siguienteNodo];

            // Si no hay conexión entre los nodos, esta ruta es inválida
            if (pesoArista == BaseGrafo.INF) {
                return; 
            }

            costeActual += pesoArista;
            nodoActual = siguienteNodo;
        }

        // Finalmente, sumamos el peso de regresar al nodo 0 para cerrar el ciclo
        int pesoRegreso = G.edge[nodoActual][0];
        if (pesoRegreso == BaseGrafo.INF) {
            return;
        }
        costeActual += pesoRegreso;

        // Si esta ruta completa es mejor que la que teníamos guardada, la actualizamos
        if (costeActual < mejorCoste) {
            mejorCoste = costeActual;
            
            // Guardamos el orden de los nodos que forman el mejor camino
            mejorCamino[0] = 0;
            for (int i = 0; i < arr.length; i++) {
                mejorCamino[i + 1] = arr[i];
            }
            mejorCamino[V] = 0;
        }
    }
}