import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arr = new int[N][M];
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = cnt;
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("###################");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 3 >=  N) break;
                if (j + 3 >=  M) break;

                for (int k = i; k < i + 4; k++) {
                    for (int l = j; l < j + 4; l++) {
                        System.out.print(arr[k][l] + " ");
                    }
                    System.out.println();
                }
                System.out.println("###########");
            }
        }
    }
}
