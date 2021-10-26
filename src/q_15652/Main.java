package q_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] answer;
    static int N;
    static int M;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        Main T = new Main();
        T.backtracking(0, 0);
        System.out.println(builder.toString());
    }

    private void backtracking(int idx, int l) {
        if (l == M) {
            for (int i = 0; i < M; i++) {
                builder.append(answer[i]).append(" ");
            }

            builder.append("\n");
        } else {
            for (int i = idx; i < N; i++) {
                answer[l] = arr[i];
                backtracking(arr[i] - 1, l + 1);
            }
        }
    }
}