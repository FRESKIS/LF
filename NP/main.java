import algoritmos.Backtracking;
import algoritmos.HeldKarp;
import grafos.BaseGrafo;

// COMPILAR (desde carpeta NP): javac algoritmos/Backtracking.java algoritmos/HeldKarp.java grafos/BaseGrafo.java main.java
// EJ. de Ejecución: java main <1/2/3> <grafoX>

public class main {
    public static void main(String[] args) {

        // Argumentos que puedes pasar desde la terminal para elegir el grafo y el algoritmo
        if (args.length < 2) {
            System.out.println("Por favor, pasa dos argumentos: <algoritmo> <grafo>");
            return;
        }

        // Obtener el grafo y algoritmo desde los argumentos
        String algoritmo = args[0];  // '1' para Backtracking, '3' para HeldKarp
        String archivoGrafo = args[1];  // 'grafo15', 'grafo1', etc.

        BaseGrafo grafo = new BaseGrafo(archivoGrafo);
        
        long startTime;
        long endTime;

        switch (algoritmo) {
            case "1":
                Backtracking algorithm = new Backtracking();
                System.out.println("---------------");
                startTime = System.nanoTime();
                System.out.println("Mejor coste: "+ algorithm.solve(grafo));
                endTime = System.nanoTime();
                System.out.println("Tiempo: " + (endTime-startTime) / 1_000_000_000.0);
                System.out.println("---------------");
                break;

            case "3":
                HeldKarp algorithm1 = new HeldKarp();
                System.out.println("---------------");
                startTime = System.nanoTime();
                System.out.println("Mejor Coste: "+ algorithm1.solve(grafo));
                endTime = System.nanoTime();
                System.out.println("Tiempo: " + (endTime-startTime) / 1_000_000_000.0);
                System.out.println("---------------");
                break;
            default:
                throw new Error("Argumento invalido");
        }

        
    }
}
