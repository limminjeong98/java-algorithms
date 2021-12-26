package bfs;

import java.util.*;

public class ShortestPathBfs {
    static final int MAX_N = 10;
    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];

    static class Point {
        Point(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }

        int row, col, dist;
    }

    private static int bfs(int sRow, int sCol, int dRow, int dCol) {
        boolean[][] visited = new boolean[MAX_N][MAX_N];
        Queue<Point> queue = new LinkedList<>();
        visited[sRow][sCol] = true;
        queue.add(new Point(sRow, sCol, 0));

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            if (cur.row == dRow && cur.col == dCol) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + D[i][0], nc = cur.col + D[i][1];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) {
                    continue;
                }
                if (visited[nr][nc]) continue;
                if (Board[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc, cur.dist + 1));
            }
        }
        return -1;
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
        // 0 1 1 1 1
        // 0 0 0 0 0
        // 1 1 1 1 0
        // 0 0 0 0 0
        int sRow, sCol, dRow, dCol;
        sRow = sc.nextInt();
        sCol = sc.nextInt();
        dRow = sc.nextInt();
        dCol = sc.nextInt();
        // 0 1 4 2
        System.out.println(bfs(sRow, sCol, dRow, dCol));
        // 11
    }


}

