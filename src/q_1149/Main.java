package q_1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int[][] arr;
  static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(T.solution(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(int N) {
        int r = DFS(N - 1, 0);
        int g = DFS(N - 1, 1);
        int b = DFS(N - 1, 2);
        return Math.min(Math.min(r, g), Math.min(g, b));
    }

    private int DFS(int idx, int color) {
        if (dp[idx][color] > 0) {
            return dp[idx][color];
        }

        if (idx == 0) {
            return dp[idx][color];
        }

        if (color == 0) {
            // RED
            return dp[idx][0] = Math.min(DFS(idx - 1, 1), DFS(idx - 1, 2)) + arr[idx][0];
        } else if (color == 1) {
            // GREEN
            return dp[idx][1] = Math.min(DFS(idx - 1, 0), DFS(idx - 1, 2)) + arr[idx][1];
        } else {
            // BLUE
            return dp[idx][2] = Math.min(DFS(idx - 1, 0), DFS(idx - 1, 1)) + arr[idx][2];
        }
    }
}