package q_2580;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[9][9];
    static List<Point> empty = new ArrayList<>();
    static boolean flag = false;
    static StringBuilder builder = new StringBuilder();

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    empty.add(new Point(i, j));
                }
            }
        }

        Main T = new Main();
        T.backtracking(0);
        System.out.println(builder.toString());
    }

    private void backtracking(int idx) {
        if (flag) return;
        if (idx == empty.size()) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    builder.append(arr[i][j]).append(" ");
                }

                builder.append("\n");
            }

            return;
        }

        Point p = empty.get(idx);
        for (int v = 1; v <= 9; v++) {
            if (possible(p.x, p.y, v)) {
                arr[p.x][p.y] = v;
                backtracking(idx + 1);
                arr[p.x][p.y] = 0;
            }
        }
    }

    private boolean possible(int x, int y, int v) {
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == v) return false;
            if (arr[i][y] == v) return false;
        }

        int sr = x / 3 * 3;
        int sc = y / 3 * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (arr[i][j] == v) return false;
            }
        }

        return true;
    }
}