package q_2108;

import java.io.*;

public class Main {

    /**
     * -4000 ~ 4000 까지 배열로 나누어 카우팅 정렬
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Main T = new Main();
        T.solution(N, arr, sum);
    }

    private void solution(int N, int[] arr, int sum) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] cnt = new int[8000 + 1];
        for (int i = 0; i < N; i++) {
            cnt[4000 + arr[i]] += 1;
        }

        int freqMax = Integer.MIN_VALUE;
        int freqIdx = 0;
        for (int i = 0; i < 8001; i++) {
            if (cnt[i] > freqMax) {
                freqMax = cnt[i];
                freqIdx = i;
            }
        }

        int freq = 0;
        for (int i = 0; i < 8001; i++) {
            if (freqMax == cnt[i]) freq++;
            if (freq == 2) {
                freqIdx = i;
                break;
            }
        }


        for (int i = 1; i < 8001; i++) {
            cnt[i] = cnt[i - 1] + cnt[i];
        }

        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            s[cnt[4000 + arr[i]] - 1] = arr[i];
            cnt[4000 + arr[i]] -=  1;
        }

        int mid = s[N / 2];
        int range = s[N - 1] - s[0];
        int f = freqIdx - 4000;
        bw.write(String.format("%.0f", (float) sum / N) + "\n");
        bw.write(mid + "\n");
        bw.write(f + "\n");
        bw.write(range + "\n");
        bw.flush();
        bw.close();
    }
}