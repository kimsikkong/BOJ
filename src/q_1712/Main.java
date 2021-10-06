package q_1712;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int answer;
        if (b >= c) answer = -1;
        else {
            answer = a / (c - b) + 1;
        }

        System.out.print(answer);
    }
}
