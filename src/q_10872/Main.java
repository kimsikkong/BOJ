package q_10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        Main T = new Main();
        System.out.print(T.factorial(n));
    }

    public int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        else {
            return n * factorial(n - 1);
        }
    }
}
