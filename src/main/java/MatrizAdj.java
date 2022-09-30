import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class MatrizAdj {
    LeitorTXT lerTXT = new LeitorTXT("src/main/java/pequenoG.txt");
    ArrayList<String> linhas = lerTXT.read();
    String [] ante = new String[Integer.parseInt(linhas.get(0))];
    int s = 0;
    int[][] matAdj = new int[Integer.parseInt(linhas.get(0))][Integer.parseInt(linhas.get(1))];

    public static void main(String[] args) {
        MatrizAdj run = new MatrizAdj();
        LeitorTXT lerTXT = new LeitorTXT("src/main/java/pequenoG.txt");
        ArrayList<String> linhas = lerTXT.read();
        for (int i = 0; i < run.matAdj.length; i++) {
            String[] valores = linhas.get(i + 2).split(" ");
            run.matAdj[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])] = 1;
            run.matAdj[Integer.parseInt(valores[1])][Integer.parseInt(valores[0])] = 1;
        }
        System.out.println("Matriz Adjacência");
        for (int i = 0; i < run.matAdj.length; i++) {
            for (int j = 0; j < run.matAdj[0].length; j++) {

                System.out.print(run.matAdj[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("========== Imprimindo BFS ==========");
        run.bfs(run.matAdj,run.s);
    }

    double inf = Double.POSITIVE_INFINITY;
    double [] d = new double[matAdj.length];
    String[] cor = new String[matAdj.length];
    
    void bfs (int [][]matAdj, int s) {
        int u, v;
        Queue<Integer> fila = new LinkedList<>();
        for (u = 0; u < matAdj.length; u++) {
            cor[u] = "BRANCO";
            d[u] = inf;
            ante[u] = null;
            cor[s] = "CINZA";
            d[s] = 0;
            fila.add(s);
        }
        for (u = 0; u < matAdj.length; u++) {
            while (!fila.isEmpty()) {
                u = fila.poll();
            }
            for (v = 0; v < matAdj[0].length; v++) {
                if (matAdj[u][v] == 1) {
                    if (cor[v] == "BRANCO") {
                        cor[v] = "CINZA";
                        d[v] = d[u] + 1;
                        ante[v] = String.valueOf(u);
                        fila.add(v);
                    }
                }
            }
            cor[u] = "PRETO";
        }
         printCaminho(6);
    }

    void printCaminho(int vertice) {
        if (vertice == s) {
            System.out.println(s);
        } else if (ante[vertice] == null) {
            System.out.println("Não há caminho");
        } else {
            printCaminho(Integer.parseInt(ante[vertice]));
            System.out.println(vertice);
        }
    }
}
