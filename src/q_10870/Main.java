package q_10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        Main T = new Main();
        System.out.print(T.fibonacci(n));
    }

    public int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}