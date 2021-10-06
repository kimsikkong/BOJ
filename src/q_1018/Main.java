package q_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chars = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                chars[i][j] = c;
            }
        }

        Main T = new Main();
        T.solution(N, M, chars);
    }

    private void solution(int N, int M, char[][] chars) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 7 >= N) break;
                if (j + 7 >= M) break;

                int _answer = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (k % 2 == 0) {
                            if (l % 2 == 0 && chars[k][l] != 'B') _answer++;
                            if (l % 2 != 0 && chars[k][l] != 'W') _answer++;
                        } else {
                            if (l % 2 == 0 && chars[k][l] != 'W') _answer++;
                            if (l % 2 != 0 && chars[k][l] != 'B') _answer++;
                        }
                    }
                }

                answer = Math.min(answer, _answer);
            }
        }

        int temp = answer;
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 7 >= N) break;
                if (j + 7 >= M) break;

                int _answer = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (k % 2 == 0) {
                            if (l % 2 == 0 && chars[k][l] != 'W') _answer++;
                            if (l % 2 != 0 && chars[k][l] != 'B') _answer++;
                        } else {
                            if (l % 2 == 0 && chars[k][l] != 'B') _answer++;
                            if (l % 2 != 0 && chars[k][l] != 'W') _answer++;
                        }
                    }
                }

                answer = Math.min(answer, _answer);
            }
        }

        answer = Math.min(temp, answer);
        System.out.println(answer);
    }
}
