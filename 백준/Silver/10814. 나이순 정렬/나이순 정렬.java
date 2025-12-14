import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int id;
        int age;
        String name;

        public Person(int id,int age,String name) {
            this.id=id;
            this.age=age;
            this.name=name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            id++;
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(id,age,name));
        }

      //다중 정렬 
        list.sort((s1,s2) -> {
          //나이 오름차순
            if (s1.age != s2.age) {
                return s1.age - s2.age;
            }
          //나이가 같을 경우 가입일자(id) 오름차순, 문자열의 경우 compareTo() 
            return Integer.compare(s1.id,s2.id);
        });


        StringBuilder sb = new StringBuilder();
        for (Person s : list) {
            System.out.println(s.age+" "+s.name);
        }
    }
}
