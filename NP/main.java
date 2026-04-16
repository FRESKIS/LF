import algoritmos.Backtracking;
import algoritmos.FuerzaBruta;
import algoritmos.HeldKarp;
import grafos.BaseGrafo;

// COMPILAR (desde carpeta NP): javac algoritmos/Backtracking.java algoritmos/HeldKarp.java grafos/BaseGrafo.java main.java

// Los parámetros para ejecutarlo serán , un número del 1 al 3 que indicarán el agoritmo a ejecutar 
// (1: Backtracking, 2: FuerzaBurta, 3:HeldKarp)
// Y un segundo parámetro que sera el nombre del archivo del grafo a leer (grafo1,grafo2,grafo3,grafo4,grafo10,grafo15,grafo20)
// EJ. de Ejecución de Held-Karp con grafo 4: java main 3 grafo4 

public class main {
    public static void main(String[] args) {

        // Argumentos que puedes pasar desde la terminal para elegir el grafo y el algoritmo
        if (args.length < 2) {
            System.out.println("Por favor, pasa dos argumentos: <algoritmo> <grafo>");
            return;
        }

        // Obtener el grafo y algoritmo desde los argumentos
        String algoritmo = args[0];  
        String archivoGrafo = args[1];  

        BaseGrafo grafo = new BaseGrafo(archivoGrafo);
        
        long startTime;
        long endTime;

        Runtime runtime = Runtime.getRuntime();

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

            case "2":
                FuerzaBruta algoritmoFB = new FuerzaBruta();
                System.out.println("------- FUERZA BRUTA --------");
                
                // Sugerimos al recolector de basura limpiar memoria antes de medir
                runtime.gc(); 
                long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
                
                startTime = System.nanoTime();
                System.out.println("Costo devuelto: " + algoritmoFB.solve(grafo));
                endTime = System.nanoTime();
                
                long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
                long memoriaUsadaBytes = memoriaDespues - memoriaAntes;
                double memoriaUsadaMB = memoriaUsadaBytes / (1024.0 * 1024.0);
                
                System.out.println("Tiempo (s): " + (endTime-startTime) / 1_000_000_000.0);
                // Si sale negativo o muy cercano a 0, la memoria usada fue mínima o el GC actuó durante la ejecución
                System.out.printf("Memoria usada: %.4f MB\n", Math.max(0, memoriaUsadaMB)); 
                System.out.println("-----------------------------");
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
