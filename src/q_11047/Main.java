package q_11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int r = K;
        for (int i = N - 1; i >= 0; i--) {
            if (c[i] <= r) {
                r -= c[i];
                answer++;
                i++;
            }

            if (r == 0) break;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}