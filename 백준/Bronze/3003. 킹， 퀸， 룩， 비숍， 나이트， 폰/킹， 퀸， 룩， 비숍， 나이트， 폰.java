import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int com[] = {1,1,2,2,2,8};
        int input[] = new int[6];
        for(int i=0; i<input.length; i++){
            input[i] = sc.nextInt();
            System.out.print(com[i] - input[i] + " ");
        }
    }
}