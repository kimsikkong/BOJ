package q_9251;

import java.io.*;
import java.util.Arrays;

public class Main {

    static char[] lc;
    static char[] rc;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lc = br.readLine().toCharArray();
        rc = br.readLine().toCharArray();
        dp = new int[lc.length][rc.length];
        for (int i = 0; i < lc.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        Main T = new Main();
        int answer = T.DFS(lc.length - 1, rc.length - 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // https://ko.wikipedia.org/wiki/%EC%B5%9C%EC%9E%A5_%EA%B3%B5%ED%86%B5_%EB%B6%80%EB%B6%84_%EC%88%98%EC%97%B4
    public int DFS(int lp, int rp) {
        if (lp < 0 || rp < 0) return 0;
        if (dp[lp][rp] > -1) return dp[lp][rp];

        if (lc[lp] == rc[rp]) {
            return dp[lp][rp] = DFS(lp - 1, rp - 1) + 1;
        } else {
            return dp[lp][rp] = Math.max(DFS(lp - 1, rp), DFS(lp, rp - 1));
        }
    }
}