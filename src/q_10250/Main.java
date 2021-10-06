package q_10250;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] heights = new int[k];
        int[] widths = new int[k];
        int[] N = new int[k];

        for (int i = 0; i < k; i++) {
            heights[i] = scanner.nextInt();
            widths[i] = scanner.nextInt();
            N[i] = scanner.nextInt();
        }

        Main T = new Main();
        T.solution(k, heights, widths, N);
    }

    private void solution(int k, int[] heights, int[] widths, int[] N) {
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int height = heights[i];
            int width = widths[i];
            int n = N[i];

            int w = n / height;
            int h = n % height;

            if (h == 0) h = height;
            else w += 1;

            String _w = w < 10 ? "0" + w : String.valueOf(w);
            String answer = String.format("%s%s", h, _w);
            answers.add(answer);
        }

        answers.forEach(System.out::println);
    }
}
