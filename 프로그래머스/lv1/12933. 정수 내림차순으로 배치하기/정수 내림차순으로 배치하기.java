import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
    
        String answer = "";
        
        String str = Long.toString(n);
        String[] arr = str.split("");
        
        Integer[] newArr = new Integer[arr.length];
        
        for (int i = 0; i < arr.length; i++){
            newArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(newArr, Collections.reverseOrder());
        
        for (int j = 0; j < newArr.length; j++){
            answer += newArr[j];
        }
        return Long.parseLong(answer);
    }
}