import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        
        for (String s : participant){
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        
        for (String c : completion){
            int v = map.get(c) -1;
            if (v == 0){
                map.remove(c);   
            } else {
                map.put(c,v);
            }
        }
        
        answer = map.keySet().iterator().next();
        
        
        
        return answer;
    }
}