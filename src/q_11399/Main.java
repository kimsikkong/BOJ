package q_11399;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(t);
        int sum = 0;
        int acc = 0;
        for (int i = 0; i < N; i++) {
            sum += t[i];
            acc += sum;
        }

        bw.write(acc + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}