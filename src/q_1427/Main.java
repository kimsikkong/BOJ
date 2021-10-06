package q_1427;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Main T = new Main();
        T.solution(N);
    }

    private void solution(String N) throws IOException {
        int[] arr = new int[N.length()];
        int[] cnt = new int[10];
        for (int i = 0; i < N.length(); i++) {
            arr[i] = Character.getNumericValue(N.charAt(i));
            cnt[arr[i]] += 1;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }

        int[] result = new int[N.length()];
        for (int j : arr) {
            result[cnt[j] - 1] = j;
            cnt[j] -= 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            sb.append(result[i]);
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}