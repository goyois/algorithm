import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            set.add(c);
        }
        
        for(char c : set){
            sb.append(c);
        }
        
        answer = sb.toString();    
        return answer;
    }
}