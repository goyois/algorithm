
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int tmp = 0;
        int first = Integer.parseInt(st.nextToken());
        boolean isFlag = true;

        if (first == 1) {
            for (int i = 2; i <= 8; i++) {
                tmp = Integer.parseInt(st.nextToken());
                if (tmp != i) {
                    isFlag = false;
                }
            }
            if (isFlag) System.out.println("ascending");
        } else if (first == 8) {
            for (int i = 7; i >= 1; i--) {
                tmp = Integer.parseInt(st.nextToken());
                if (tmp != i) {
                    isFlag = false;
                }
            }
            if (isFlag) System.out.println("descending");
        } else System.out.println("mixed");
        if (!isFlag) System.out.println("mixed");
    }
}
