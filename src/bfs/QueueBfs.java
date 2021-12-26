package bfs;

import java.util.*;

public class QueueBfs {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];

    static void bfs(int node) {
        boolean[] visited = new boolean[MAX_N];

        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            System.out.print(cur + " ");
            for (int next = 0; next < N; next++) {
                if (!visited[next] && Graph[cur][next] != 0) {
                    visited[next] = true;
                    queue.add(next);
                }
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
        bfs(0);
        //        0
        //        1
        //        2
        //        3
        //        4
    }
}
