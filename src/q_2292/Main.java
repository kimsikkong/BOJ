package q_2292;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 1;
        int k = 1;
        if (n == 1) {
            System.out.println(1);
        } else {
            while (true) {
                sum += k * 6;
                if (n <= sum) break;
                k++;
            }

            System.out.print(k + 1);
        }
    }
}
