package dfs;

import java.util.*;

public class StackDfs {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];

    static void dfs(int node) {
        boolean[] visited = new boolean[MAX_N];
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            int currentNode = stack.pop();
            if (visited[currentNode]) continue;
            visited[currentNode] = true;
            System.out.print(currentNode + " ");
            for (int nextNode = 0; nextNode < N; nextNode++) {
                if (!visited[nextNode] && Graph[currentNode][nextNode] != 0) {
                    stack.push(nextNode);
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
        dfs(0);
        //        0
        //        2
        //        4
        //        3
        //        1
    }
}
