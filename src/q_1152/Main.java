package q_1152;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        if (s.isBlank()) {
            System.out.println(0);
        } else {
            String[] w = s.split("\\s");
            System.out.println(w.length);
        }
    }
}
