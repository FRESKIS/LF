package grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BaseGrafo {
    
    public static final int INF = 99999999;
    public int V, E;
    public int edge[][];

    // Constructor to initialize the graph
    public BaseGrafo(String FileName) {

        try (BufferedReader br = new BufferedReader(new FileReader("grafos/" + FileName))) {
            // 1. Leer las dos primeras líneas (filas y columnas)
            int dim = Integer.parseInt(br.readLine().trim());
            
            V = dim;
            E = 0;
            edge = new int[dim][dim];

            // 2. Leer cada fila de la matriz
            for (int i = 0; i < dim; i++) {
                String linea = br.readLine();
                if (linea == null) break;

                // Separar por el carácter ':'
                String[] valores = linea.split(":");

                for (int j = 0; j < dim; j++) {
                    if (!valores[j].equalsIgnoreCase("I")) {
                        edge[i][j] = Integer.parseInt(valores[j]);
                        if (j > i) {
                            E++;
                        }
                    } else {
                        edge[i][j] = INF;
                    }
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
