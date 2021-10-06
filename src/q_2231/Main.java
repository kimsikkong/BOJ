package q_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = i;
            int k = i;
            while (k != 0) {
                sum += k % 10;
                k = k / 10;
            }

            if (sum == n) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }
}
