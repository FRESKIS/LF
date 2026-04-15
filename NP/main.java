import algoritmos.Backtracking;
import algoritmos.HeldKarp;
import grafos.BaseGrafo;


public class main {
    public static void main(String[] args) {
        BaseGrafo grafo = new BaseGrafo("grafo1");
        
        long startTime;
        long endTime;

        switch ("1") {
            case "1":
                Backtracking algorithm = new Backtracking();
                System.out.println("---------------");
                startTime = System.nanoTime();
                System.out.println(algorithm.solve(grafo));
                endTime = System.nanoTime();
                System.out.println((endTime-startTime) / 1_000_000_000.0);
                System.out.println("---------------");
                break;

            case "3":
                HeldKarp algorithm1 = new HeldKarp();
                System.out.println("---------------");
                startTime = System.nanoTime();
                System.out.println(algorithm1.solve(grafo));
                endTime = System.nanoTime();
                System.out.println((endTime-startTime) / 1_000_000_000.0);
                System.out.println("---------------");
                break;
            default:
                throw new Error("Argumento invalido");
        }

        
    }
}
