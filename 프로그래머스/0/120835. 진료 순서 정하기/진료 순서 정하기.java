import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Integer[] tmp = new Integer[emergency.length];
        int[] answer = new int[emergency.length];
        
        for (int i = 0; i < emergency.length; i++){
            tmp[i] = emergency[i];
        }
        Arrays.sort(tmp,Collections.reverseOrder());
        
        for (int i = 0; i < emergency.length; i++){
            for (int j = 0; j < tmp.length; j++){
                if (emergency[i] == tmp[j]){
                    answer[i] = j+1;
                }
            }
        }
    
        return answer;
    }
}