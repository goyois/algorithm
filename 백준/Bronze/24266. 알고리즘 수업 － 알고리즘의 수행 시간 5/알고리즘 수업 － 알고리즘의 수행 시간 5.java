import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        sb.append(n * n * n).append("\n").append(3);
        System.out.println(sb);
    }
}