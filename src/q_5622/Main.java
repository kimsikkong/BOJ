package q_5622;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int answer = chars.length;
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            answer += (c - 65) / 3 + 2;
            if (c == 'S' || c == 'V' || c == 'Y' || c == 'Z') answer--;
        }

        System.out.print(answer);
    }
}