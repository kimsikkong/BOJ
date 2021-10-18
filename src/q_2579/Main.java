package q_2579;

import java.io.*;

public class Main {

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0] = arr[0];
        Main T = new Main();
        bw.write(T.DFS(n - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int DFS(int idx) {
        if (idx < 0) return 0;
        if (dp[idx] > 0) return dp[idx];
        // dp[n] = arr[n] + dp[n-2]
        // dp[n] = arr[n] + arr[n-1] + dp[n-3]
        return dp[idx] = Math.max(DFS(idx - 2) + arr[idx], DFS(idx -3) + arr[idx - 1] + arr[idx]);
    }
}