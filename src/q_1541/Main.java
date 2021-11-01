package q_1541;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[51];
        char[] ops = new char[51];
        int idx = 0;
        String s = br.readLine();
        String temp = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                temp = temp.concat(String.valueOf(c));
            } else {
                arr[idx] = Integer.parseInt(temp);
                ops[idx] = c;
                temp = "";
                idx++;
            }
        }

        arr[idx] = Integer.parseInt(temp);
        int sum = arr[0];
        for (int i = 1; i <= idx; i++) {
            int j = i - 1;
            char op = ops[j];
            if (op == '+') {
                sum += arr[i];
            } else if (op == '-') {
                int t = 0;
                int k = i;
                do {
                    t += arr[k];
                    op = ops[j + 1];
                    k++;
                    j++;
                } while (j <= idx && op != '-');

                sum -= t;
                i = k - 1;
            } else {
                break;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}