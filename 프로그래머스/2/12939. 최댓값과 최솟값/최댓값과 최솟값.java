import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
		String[] arr = s.split(" ");
        int[] num = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++){
            num[i] = Integer.parseInt(arr[i]);
        }
        
        int min = num[0];
        int max = num[0];
        
        for (int i = 0; i < num.length; i++){
            if (min > num[i]){
                min = num[i];
            }
            if (max < num[i]){
                max = num[i];
            }
        }    
        
        return answer = min + " " + max;
    }
}