package q_1316;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            list.add(s);
        }

        Main T = new Main();
        T.solution(list);
    }

    private void solution(ArrayList<String> list) {
        int answer = 0;
        for (String s : list) {
            char[] chars = s.toCharArray();
            boolean m = true;
            for (int j = 0; j < chars.length; j++) {
                if (j != s.indexOf(chars[j]) && chars[j] != chars[j - 1]) {
                    m = false;
                    break;
                }
            }

            if (m) answer++;
        }

        System.out.print(answer);
    }
}
