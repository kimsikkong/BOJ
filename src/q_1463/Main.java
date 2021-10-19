package q_1463;

import java.io.*;

public class Main {

    static int[] dp = new int[1000002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Main T = new Main();
        for (int i = 2; i <= N; i++) {
            dp[i] = T.DFS(i, 0);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int DFS(int N, int cnt) {
        if (dp[N] > 0) return dp[N] + cnt;
        if (N == 1) return cnt;
        else {
            int a = N % 3 == 0 ? DFS(N / 3, cnt + 1) : Integer.MAX_VALUE;
            int b = N % 2 == 0 ? DFS(N / 2, cnt + 1) : Integer.MAX_VALUE;
            int c = DFS(N - 1, cnt + 1);
            return dp[N] = Math.min(Math.min(a, b), Math.min(b, c));
        }
    }
}