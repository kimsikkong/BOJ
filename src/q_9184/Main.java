package q_9184;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[][][] dy = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Main T = new Main();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int r = T.w(a, b, c);
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + r + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int w(int a, int b, int c) {
        if (a >= 0 && b >= 0 && c >= 0 && a <= 20 && b <= 20 && c <= 20 && dy[a][b][c] > 0) return dy[a][b][c];
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return dy[20][20][20] = w(20, 20, 20);
        if (a < b && b < c) return dy[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        return dy[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}