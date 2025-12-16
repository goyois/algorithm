
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] gradeArr = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        Double[] scoreArr = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
        double totalSum = 0;
        double scoreSum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            for (int j = 0; j < gradeArr.length; j++) {
                if (grade.equals(gradeArr[j])) {
                    scoreSum += score * scoreArr[j];
                    if (!grade.equals("P")) {
                        totalSum += score;
                    }
                }
            }
        }
        double avg = scoreSum / totalSum;
        System.out.printf("%.6f\n",avg);
    }
}