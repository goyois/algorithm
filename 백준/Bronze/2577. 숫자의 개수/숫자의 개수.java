import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        for (int i = 0; i < 2; i++) {
             sum *= sc.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i,0);
        }

        String s = String.valueOf(sum);
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i)-48;
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            System.out.println(x.getValue());
        }
    }
}
