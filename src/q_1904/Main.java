package q_1904;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= N; i++) {
            dp[2] = dp[0] + dp[1];
            dp[2] = dp[2] % 15746;
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        if (N <= 2) {
            bw.write(dp[N - 1] + "\n");
        } else {
            bw.write(dp[2] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}