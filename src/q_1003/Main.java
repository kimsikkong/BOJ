package q_1003;

import java.io.*;

public class Main {

    public static int[][] arr = new int[41][2];
    public static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        answer = new int[T][2];
        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = -1;
            }
        }

        arr[0][0] = 1;
        arr[1][1] = 1;
        Main m = new Main();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            m.solution(N, i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < T; i++) {
            bw.write(answer[i][0] + " " + answer[i][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int N, int idx) {
        answer[idx][0] = calcZero(N);
        answer[idx][1] = calcOne(N);
    }

    private int calcZero(int n) {
        if (n >= 2 && arr[n][0] != -1) {
            return arr[n][0];
        }

        if (n == 0) return 1;
        else if (n == 1) return 0;
        else {
            arr[n][0] =  calcZero(n - 2) + calcZero(n - 1);
            return arr[n][0];
        }
    }

    private int calcOne(int n) {
        if (n >= 2 && arr[n][1] != -1) {
            return arr[n][1];
        }

        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            arr[n][1] =  calcOne(n - 2) + calcOne(n - 1);
            return arr[n][1];
        }
    }
}