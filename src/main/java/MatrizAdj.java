import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class MatrizAdj {
    LeitorTXT lerTXT = new LeitorTXT("C:/Users/Gabriel/IdeaProjects/Atividade1Grafos/src/main/java/pequenoG.txt");
    ArrayList<String> linhas = lerTXT.read();
    String [] ante = new String[Integer.parseInt(linhas.get(0))];
    public static void main(String[] args) {
        LeitorTXT lerTXT = new LeitorTXT("C:/Users/Gabriel/IdeaProjects/Atividade1Grafos/src/main/java/pequenoG.txt");
        ArrayList<String> linhas = lerTXT.read();
//        int[] grau = new int[Integer.parseInt(linhas.get(0))];
        int[][] matAdj = new int[Integer.parseInt(linhas.get(0))][Integer.parseInt(linhas.get(1))];
//        int isolados = 0, extremidades = 0;
        for (int i = 0; i < matAdj.length; i++) {
            String[] valores = linhas.get(i + 2).split(" ");
            matAdj[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])] = 1;
            matAdj[Integer.parseInt(valores[1])][Integer.parseInt(valores[0])] = 1;
//            for (int j = 0; j < matAdj[0].length; j++) {
//                if (j == Integer.parseInt(valores[0]) || j == Integer.parseInt(valores[1])) {
//                    grau[j]++;
//                }
//                if (j == Integer.parseInt(valores[0]) && j == Integer.parseInt(valores[1])) {
//                    isolados++;
//                }
//            }
//        }
        System.out.println("Matriz Adjacência");
//        for (int i = 0; i < matAdj.length; i++) {
//            if (grau[i] == 1) {
//                extremidades++;
//            }
            for (int j = 0; j < matAdj[0].length; j++) {

                System.out.print(matAdj[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
//        System.out.println("Ordem = " + Integer.parseInt(linhas.get(0)));
//        System.out.println("Tamanho = " + Integer.parseInt(linhas.get(1)));
//        System.out.println();
//        System.out.println("Grau de cada vertice");
//        for (int i = 0; i < Integer.parseInt(linhas.get(0)); i++) {
//            System.out.println("Grau de " + i + " = " + grau[i]);
//        }
//        System.out.println();
//        System.out.println("Vertices isolados = " + isolados);
//        System.out.println("Vértices de extremidade = " + extremidades);
//        System.out.println();
        System.out.println("========== Printing BFS ==========");
        bfs(matAdj,5);
    }

    void bfs(int[][] matAdj, int inicio){
        String [] cor = new String[matAdj.length];
        double [] d = new double[matAdj.length];
        double inf = Double.POSITIVE_INFINITY;
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 0; i < matAdj.length; i++) {
            for (int j = 0; j < matAdj[0].length; j++) {
                if(matAdj[i][j]==1 || matAdj[j][i]==1 && matAdj[i][j] != inicio) {
                    cor[j] = "branco";
                    d[j] = inf;
                    ante[j] = null;
                }
                if (i == inicio) {
                    cor[inicio] = "cinza";
                    d[inicio] = 0;
                    fila.add(inicio);
                }
                while (!fila.isEmpty()){
                    fila.poll();
                }
            }
        }
        for (int i = 0; i < matAdj.length; i++) {
            for (int j = 0; j < matAdj[0].length; j++) {
                if (cor[j] == "branco") {
                    cor[j] = "cinza";
                    d[j] = d[i] + 1;
                    ante[j] = String.valueOf(j - 1);
                    fila.add(j);
                }
                cor[j] = "preto";
            }
        }
        printBfs(6);
    }
    void printBfs(int vertice) {
        for (int i = 0; i < ante.length; i++) {
            if (vertice == i) {
                System.out.println(i);
            } else if (ante[vertice] == null) {
                System.out.println("Não há caminho");
            } else {
                printBfs(Integer.parseInt(ante[vertice]));
                System.out.println(vertice);
            }
        }
    }
}



