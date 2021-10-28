package q_9663;

import java.io.*;

public class Main {

    static int N;
    static int[][] arr;
    static int answer;
    static int[] rows;
    static int[] cols;
    static int[] dig = new int[31];
    static int[] dig2 = new int[31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        rows = new int[N];
        cols = new int[N];
        Main T = new Main();
        T.backtracking(0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void backtracking(int row) {
        if (row == N) {
            answer++;
        } else {
            for (int i = 0; i < N; i++) {
                if (canPutQueen(row, i)) {
                    rows[row] = 1;
                    cols[i] = 1;
                    dig[row + i] = 1;
                    dig2[row - i + N] = 1;
                    backtracking(row + 1);
                    rows[row] = 0;
                    cols[i] = 0;
                    dig[row + i] = 0;
                    dig2[row - i + N] = 0;
                }
            }
        }
    }

    private boolean canPutQueen(int x, int y) {
        if (rows[x] == 1) return false;
        if (cols[y] == 1) return false;
        if (dig[x + y] == 1) return false;
        if (dig2[x - y + N] == 1) return false;
        return true;
    }
}


//            for (int i = 0; i < N; i++) {
//                System.out.printf("[%d], x : [%d], y : [%d]\n", i, q[i][0], q[i][1]);
//            }
//
//            System.out.println("==================");

//
//    private void backtracking(int x, int y, int l) {
//        if (l == N) {
//            answer++;
//            for (int i = 0; i < N; i++) {
//                System.out.printf("[%d], x : [%d], y : [%d]\n", i, q[i][0], q[i][1]);
//            }
//
//            System.out.println("==================");
//        } else {
//            for (int i = x; i < N; i++) {
//                boolean match = false;
//                for (int j = y; j < N; j++) {
//                    if (canPutQueen(i, j)) {
//                        match = true;
//                        q[l][0] = i;
//                        q[l][1] = j;
//                        backtracking(i + 1, y, l + 1);
//                        q[l][0] = -1;
//                        q[l][1] = -1;
//                    }
//                }
//
//                if (!match) break;
//            }
//        }
//    }
