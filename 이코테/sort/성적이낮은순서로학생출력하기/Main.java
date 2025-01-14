package sort.성적이낮은순서로학생출력하기;

import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    //성적이 낮은 순서대로 정렬(오름차순)
    @Override
    public int compareTo(Student other) {
        return this.score - other.score;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());    //학생 수

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}