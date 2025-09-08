import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String lowerStr = my_string.toLowerCase();
        char[] arr = lowerStr.toCharArray();
        Arrays.sort(arr);
        
        for (char c : arr){
            sb.append(c);
        }
        
        String answer = sb.toString();
        return answer;
    }
}