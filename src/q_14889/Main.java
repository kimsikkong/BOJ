package q_14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] chk;
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        chk = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main T = new Main();
        T.backtracking(0, 0);
        bw.write(diff + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void backtracking(int l, int idx) {
        if (l == N / 2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j && chk[i] == 1 && chk[j] == 1) {
                        start += arr[i][j];
                    } else if (i != j && chk[i] == 0 && chk[j] == 0) {
                        link += arr[i][j];
                    }
                }
            }

            diff = Math.min(Math.abs(start - link), diff);
        }

        for (int i = idx; i < N; i++) {
            if (chk[i] == 0) {
                chk[i] = 1;
                backtracking(l + 1, i + 1);
                chk[i] = 0;
            }

            if (l == 0) break;
        }
    }
}