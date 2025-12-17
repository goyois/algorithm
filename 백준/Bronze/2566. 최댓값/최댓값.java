import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        int row = 0;
        int col = 0;
        for (int[] x : arr) {
            cnt++;
            for (int i = 0; i < x.length; i++) {
                if (x[i] > max){
                    max = x[i];
                    row = cnt;
                    col = i+1;
                }
            }
        }
        sb.append(max+"\n");
        sb.append(row+" ");
        sb.append(col);
        System.out.println(sb.toString());

    }
}
