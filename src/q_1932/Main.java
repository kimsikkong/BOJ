package q_1932;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int arr[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            while (j < i + 1) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }

            j = 0;
        }

        Main T = new Main();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, T.DFS(n - 1, i));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int DFS(int depth, int idx) {
        if (idx < 0 || idx > depth) return 0;
        if (dp[depth][idx] > 0) return dp[depth][idx];
        return dp[depth][idx] = arr[depth][idx] + Math.max(DFS(depth - 1, idx - 1), DFS(depth - 1, idx));
    }
}