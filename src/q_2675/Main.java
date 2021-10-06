package q_2675;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr[i] = x;
            String w = scanner.next();
            list.add(w);
        }

        Main T = new Main();
        T.solution(arr, list);
    }

    private void solution(int[] arr, ArrayList<String> list) {
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            String w = list.get(i);
            char[] chars = w.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < x; k++) {
                    System.out.print(chars[j]);
                }
            }
            System.out.println();
        }
    }
}
