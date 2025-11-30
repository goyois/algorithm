import java.util.*;

class Solution{
    public int solution(int []a, int []b){
        int answer = 0; 
        
        Arrays.sort(a);
        Arrays.sort(b);

        int idx = b.length -1;
        for (int i = 0; i < a.length; i++){
            answer += a[i] * b[idx];
            idx--;
        }
        

        return answer;
    }
}