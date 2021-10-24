package q_2565;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        dp = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 전봇대 A 기준 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        Arrays.fill(dp, 1);
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 교차하지 않는 최소 전깃줄 = 전체 전깃줄 - B 전봇대 최대 증가 부분수열
        bw.write(n - answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}