package dfs;

import java.util.*;

public class FloodFillDfs {
    static final int MAX_N = 10;
    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];

    static class Point {
        Point(int r, int c) {
            row = r;
            col = c;
        }

        int row, col;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 5
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Board[i][j] = sc.nextInt();
            }
        }
        // 0 0 0 0 0
        // 0 0 0 1 1
        // 0 0 0 1 0
        // 1 1 1 1 0
        // 0 0 0 0 0

        int sRow = sc.nextInt(), sCol = sc.nextInt();
        int color = sc.nextInt();
        // 1 1 3
        dfs(sRow, sCol, color);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 3 3 3 3 3
    // 3 3 3 1 1
    // 3 3 3 1 0
    // 1 1 1 1 0
    // 0 0 0 0 0

    private static void dfs(int r, int c, int color) {
        boolean[][] visited = new boolean[MAX_N][MAX_N];
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(r, c));

        while (!stack.empty()) {
            Point cur = stack.pop();
            if (visited[cur.row][cur.col]) continue;
            visited[cur.row][cur.col] = true;
            Board[cur.row][cur.col] = color;

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + D[i][0], nc = cur.col + D[i][1];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) continue;
                if (visited[nr][nc]) continue;
                if (Board[nr][nc] == 1) continue;
                stack.push(new Point(nr, nc));
            }

        }
    }
}
