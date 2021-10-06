package q_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Person {
        public int x;
        public int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            persons.add(new Person(x, y));
        }

        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int answer = 1;
            Person person = persons.get(i);
            for (int j = 0; j < N; j++) {
                Person other = persons.get(j);
                if (person.x < other.x && person.y < other.y) answer++;
            }
            answers.add(answer);
        }

        answers.forEach(answer -> System.out.print(answer + " "));
    }
}