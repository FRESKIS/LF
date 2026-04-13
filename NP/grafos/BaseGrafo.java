import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BaseGrafo {
      // Graph is Created Using Edge Class
    static class Edge {
        int node, weight;

        Edge(int i, int w) {
            node = i;
            weight = w;
        }
    }

    int V, E;
    ArrayList<Edge> edge[];

    // Constructor to initialize the graph
    public BaseGrafo(String FileName) {

        try (BufferedReader br = new BufferedReader(new FileReader("grafos/" + FileName))) {
            // 1. Leer las dos primeras líneas (filas y columnas)
            int dim = Integer.parseInt(br.readLine().trim());
            
            V = dim;
            E = 0;

            // 2. Leer cada fila de la matriz
            for (int i = 0; i < dim; i++) {
                String linea = br.readLine();
                if (linea == null) break;

                // Separar por el carácter ':'
                String[] valores = linea.split(":");

                for (int j = 0; j < dim; j++) {
                    if (!valores[j].equalsIgnoreCase("I")) {
                        edge[i].add(new Edge(j, Integer.parseInt(valores[j])));
                        E++;
                    }
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
