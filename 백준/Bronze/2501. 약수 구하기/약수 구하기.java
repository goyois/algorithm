import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0){
                cnt++;
                list.add(i);
            }
        }
        if (cnt < k) {
            System.out.println(0);
        } else {
            Collections.sort(list);
            System.out.println(list.get(k-1));
        }

    }
}
