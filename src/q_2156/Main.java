package q_2156;

import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, -1);
        dp[1] = arr[1];
        Main T = new Main();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(T.DFS(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int DFS(int n) {
        if (n <= 0) return 0;
        if (n == 1) return dp[1];
        if (dp[n] > -1) return dp[n];
        return dp[n] = Math.max(DFS(n - 1), Math.max(arr[n] + arr[n - 1] + DFS(n - 3), arr[n] + DFS(n - 2)));
    }
}