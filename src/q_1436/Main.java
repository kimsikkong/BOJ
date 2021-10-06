package q_1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int answer;
        for (int i = 666; ; i++) {
            int temp = i;
            int k = 0;
            boolean c;
            while (true) {
                if (temp % 10 == 6) {
                    c = true;
                    k++;
                } else {
                    c = false;
                    k = 0;
                }

                if (c && k == 3) {
                    cnt++;
                    break;
                }

                temp = temp / 10;
                if (temp == 0) break;
            }

            if (N == cnt) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }
}