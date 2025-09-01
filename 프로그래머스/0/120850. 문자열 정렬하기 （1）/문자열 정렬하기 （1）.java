import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String intStr = my_string.replaceAll("[^0-9]", "");
        int[] answer = new int[intStr.length()];
        
        for(int i = 0; i < intStr.length(); i++){
            answer[i] = Character.getNumericValue(intStr.charAt(i));
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}