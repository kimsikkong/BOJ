package q_12865;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] dp;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int w = arr[i][0];
            int v = arr[i][1];
            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j - w] + v, dp[j]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dp[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}