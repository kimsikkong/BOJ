package q_13305;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dis;
    static int[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dis = new int[N - 1];
        l = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        long sumLiter = 0;
        int ml = l[0];
        for (int i = 0; i < N - 1; i++) {
            if (ml > l[i]) {
                ml = l[i];
            }

            sumLiter += (long) ml * dis[i];
        }

        bw.write(sumLiter + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}