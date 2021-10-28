package q_2775;

import java.io.*;

public class Main {

    public static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        Main m = new Main();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            builder.append(m.DFS(k, n)).append("\n");
        }

        System.out.println(builder.toString());
    }

    public int DFS(int k, int n) {
        if (dp[k][n] > 0) return dp[k][n];
        if (k == 0) return n;
        else {
            int sum = 0;
            for (int i = n; i >= 0; i--) {
                sum += DFS(k - 1, i);
            }
            return dp[k][n] = sum;
        }
    }
}