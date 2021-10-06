package q_2908;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = new StringBuffer(scanner.next()).reverse().toString();
        String b = new StringBuffer(scanner.next()).reverse().toString();
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        System.out.print(Math.max(x, y));
    }
}
