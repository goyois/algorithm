import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //총 금액 x
        //물건의 종류 수 N
        //물건 값(공백)갯수


        Scanner sc = new Scanner(System.in);

        int totalPrice = sc.nextInt();
        int totalSize = sc.nextInt();
        int result = 0;

        for (int i = 1; i <= totalSize; i++) {
            int price = sc.nextInt();
            int total = sc.nextInt();
            result += price * total;
            }
        if (result == totalPrice) {
            System.out.println("Yes");
        }else
        System.out.println("No");
        }
    }