import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n,m;
    static int[] pm,ch;

    static void DFS(int L,int[] arr) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1,arr);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        // 1~3 까지의 체크 배열 생성
        // 길이는 m
        pm = new int[m];
        ch = new int[n];
        DFS(0,arr);
    }
}
