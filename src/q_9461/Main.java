package q_9461;

import java.io.*;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp = new long[101];
        int T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        Main m = new Main();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(m.DFS(N) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private long DFS(int N) {
        if (dp[N] > 0) return dp[N];
        return dp[N] = DFS(N - 3) + DFS(N - 2);
    }
}