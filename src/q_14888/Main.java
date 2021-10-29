package q_14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] op = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        T.backtracking(1, arr[0]);
        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public void backtracking(int i, int sum) {
        if (i == N) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (op[j] != 0) {
                int temp = sum;
                switch (j) {
                    case 0: sum += arr[i]; break;
                    case 1: sum -= arr[i]; break;
                    case 2: sum *= arr[i]; break;
                    case 3: sum /= arr[i]; break;
                }

                op[j] = op[j] - 1;
                backtracking(i + 1, sum);
                op[j] = op[j] + 1;
                sum = temp;
            }
        }
    }
}