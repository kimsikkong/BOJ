package q_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int max = 0;
    private static int[] arr = new int[100];
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0);
        System.out.print(max);
    }


    public static void DFS(int idx, int sum, int cnt) {
        if (sum > M) {
            return;
        }

        if (cnt == 3) {
            max = Math.max(max, sum);
        } else {
            for (int i = idx; i < N; i++) {
                sum += arr[i];
                DFS(i + 1, sum, cnt + 1);
                sum -= arr[i];
            }
        }
    }
}