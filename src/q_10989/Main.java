package q_10989;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Main T = new Main();
        T.solution(N, arr);
        br.close();
    }

    private void solution(int N, int[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int[] cnt = new int[max + 1];
        for (int i = 0; i < N; i++) {
            cnt[arr[i]] = cnt[arr[i]] + 1;
        }

        for (int i = 1; i < max + 1; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[cnt[arr[i]] - 1] = arr[i];
            cnt[arr[i]] -= 1;
        }

        for (int j : result) {
            bw.write(j + "\n");
        }

        bw.flush();
        bw.close();
    }
}