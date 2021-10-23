package q_11054;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for (int i = 0; i < N; i++) {
            // 좌측
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            // 우측
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i][0] + dp[i][1], max);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}