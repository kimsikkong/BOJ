package q_10814;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 나이순 정렬
 * 입력 : 회원 수 & 회원, 나이 (가입한 순으로 입력)
 * 출력 : 나이 순으로 출력, 나이가 같을 경우 가입한 순
 *
 * 안정 정렬 : 버블, 삽입, 병합
 * 불안정 정렬 : 선택, 퀵
 */

public class Main {

    static class Member {
        public int age;
        public String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, name);
        }

        Main T = new Main();
        T.solution(members);
        br.close();
    }

    private void solution(Member[] members) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Member[] temp = new Member[members.length];
        mergeSort(members, temp, 0, members.length - 1);
        for (Member member : members) {
            bw.write(member.age + " " + member.name + "\n");
        }

        bw.flush();
        bw.close();
    }

    private void mergeSort(Member[] members, Member[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(members, temp, start, mid);
            mergeSort(members, temp, mid + 1, end);
            merge(members, temp, start, end, mid);
        }
    }

    private void merge(Member[] members, Member[] temp, int start, int end, int mid) {
        int lt = start;
        int rt = mid + 1;
        int idx = start;

        while (lt <= mid && rt <= end) {
            if (members[lt].age <= members[rt].age) {
                temp[idx++] = members[lt++];
            } else {
                temp[idx++] = members[rt++];
            }
        }

        while (lt <= mid) {
            temp[idx++] = members[lt++];
        }

        while (rt <= end) {
            temp[idx++] = members[rt++];
        }

        for (int i = start; i <= end; i++) {
            members[i] = temp[i];
        }
    }
}