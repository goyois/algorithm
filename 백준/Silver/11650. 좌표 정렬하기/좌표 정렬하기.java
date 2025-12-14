import java.io.*;
import java.util.*;

public class Main {
    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Coordinate(x,y));
        }
        
        list.sort((s1,s2) ->{
            if (s1.x != s2.x) {
                return Integer.compare(s1.x,s2.x);
            }
            return Integer.compare(s1.y,s2.y);
        });
        
        for (Coordinate s : list) {
            System.out.println(s.x+" "+s.y);
        }
    }
}
