import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String getName() {
        return this.name;
    }

    //내림차순으로 정렬
    @Override
    public int compareTo(Student other) {
        if (this.kor != other.kor) { //1. 국어 점수가 감소하는 순서로
            return other.kor - this.kor;
        } else {    //2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
            if (this.eng != other.eng) {
                return this.eng - other.eng;
            } else {    //3. 국어, 영어 점수가 같으면 수학 점수가 감소하는 순서로
                if (this.math != other.math) {
                    return other.math - this.math;
                }
            }
        }
        return this.name.compareTo(other.name); //4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //학생 수

        List<Student> students = new ArrayList<>();
        //학생 이름, 국어, 영어, 수학 점수 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students.add(new Student(name, kor, eng, math));
        }

        Collections.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
    }
}