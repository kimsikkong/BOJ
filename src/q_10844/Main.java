package q_10844;

import java.io.*;

public class Main {

    static int[][] dp;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[10][101];
        int sum = 0;
        Main T = new Main();
        for (int i = 1; i <= 9; i++) {
            sum = (sum + T.DFS(i, N)) % MOD;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public int DFS(int n, int digit) {
        if (digit == 1) return 1;
        if (dp[n][digit] > 0) return dp[n][digit];
        int ret = 0;
        if (n != 0) {
            ret += DFS(n - 1, digit - 1);
            ret %= MOD;
        }

        if (n != 9) {
            ret += DFS(n + 1, digit - 1);
            ret %= MOD;
        }

        return dp[n][digit] = ret;
    }
}