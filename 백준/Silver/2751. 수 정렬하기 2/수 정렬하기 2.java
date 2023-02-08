import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        //시간초과로 인해 빌더 & 컬렉션 클래스 사용

        ArrayList<Integer> list = new ArrayList<Integer>();


        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for (int q : list){
            stringBuilder.append(q).append('\n');
        }
        System.out.println(stringBuilder);
    }
}