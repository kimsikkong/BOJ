package q_1037;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long answer;
        if (arr.length == 1) {
            answer = (long) arr[0] * arr[0];
        } else {
            answer = (long) arr[0] * arr[arr.length - 1];
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}