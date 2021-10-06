package q_1157;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String w = scanner.nextLine();
        Main T = new Main();
        T.solution(w);
    }

    private void solution(String w) {
        char[] chars = w.toUpperCase().toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : chars) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        String answer = "";
        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            Character c = e.getKey();
            Integer v = e.getValue();
            if (v == max) {
                answer = "?";
            } else if (v > max) {
                answer = String.valueOf(c);
                max = v;
            }
        }

        System.out.println(answer);
    }
}