package q_15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] pm;
    static int[] chk;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        pm = new int[M];
        chk = new int[N + 1];
        answer = new StringBuilder();
        Main T = new Main();
        T.DFS(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public void DFS(int l) {
        if (l == M) {
            for (int i = 0; i < M; i++) {
                answer.append(pm[i]).append(" ");
            }
            answer.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (chk[i] == 0) {
                    chk[i] = 1;
                    pm[l] = arr[i];
                    DFS(l + 1);
                    chk[i] = 0;
                }
            }
        }
    }
}