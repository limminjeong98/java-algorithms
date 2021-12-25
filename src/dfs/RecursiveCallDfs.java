package dfs;

import java.util.*;

public class RecursiveCallDfs {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];
    static boolean[] Visited = new boolean[MAX_N];

    //    recursive call
    static void dfs(int node) {
        Visited[node] = true;
        System.out.println(node + " ");

        for (int nextNode = 0; nextNode < N; nextNode++) {
            if (!Visited[nextNode] && Graph[node][nextNode] != 0) {
                dfs(nextNode);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        //        5 6

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph[u][v] = Graph[v][u] = 1;
        }
        //        0 1
        //        0 2
        //        1 3
        //        1 4
        //        2 4
        //        3 4
        dfs(0);
        //        0
        //        2
        //        4
        //        3
        //        1
    }
}
