package q_1931;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Conference {
        public int start;
        public int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Conference> cfs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            cfs.add(new Conference(s, e));
        }

        Collections.sort(cfs, (o1, o2) -> {
            if (o1.end == o2.end) return o1.start - o2.start;
            else return o1.end - o2.end;
        });
        int cnt = 1;
        int end = cfs.get(0).end;
        for (int i = 1; i < N; i++) {
            Conference c = cfs.get(i);
            if (c.start >= end) {
                cnt++;
                end = c.end;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}