package q_5086;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x;
        int y;
        do {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (x > y) {
                if (x % y == 0) sb.append("multiple");
                else sb.append("neither");
            } else if (x < y) {
                if (y % x == 0) sb.append("factor");
                else sb.append("neither");
            }

            sb.append("\n");
        } while (x != 0 && y != 0);

        System.out.println(sb);
    }
}