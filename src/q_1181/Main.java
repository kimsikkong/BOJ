package q_1181;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            if (!words.contains(w)) words.add(w);
        }

        Main T = new Main();
        T.solution(words);
        br.close();
    }

    private void solution(ArrayList<String> words) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        words.sort((o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return -1;
        });

        for (String s : words) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}