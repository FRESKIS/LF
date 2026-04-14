import algoritmos.HeldKarp;
import grafos.BaseGrafo;


public class main {
    public static void main(String[] args) {
        BaseGrafo grafo = new BaseGrafo("grafo20");
        HeldKarp algorithm = null;

        switch ("3") {
            case "1":
                //Backtracking
                break;
            case "2":
                //Branch&Bound
                break;
            case "3":
                algorithm = new HeldKarp();
                break;
            default:
                throw new Error("Argumento invalido");
        }

        System.out.println("---------------");
        long startTime = System.nanoTime();
        System.out.println(algorithm.solve(grafo));
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime) / 1_000_000_000.0);
        System.out.println("---------------");
    }
}
