import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i : arr){
            list.add(i);
        }
        
        for (int i = 0; i < delete_list.length; i++){
            for (int j = 0; j < list.size(); j++){
                if (list.get(j) == delete_list[i]){
                    list.remove(j);
                }
            }
        }
        
        
        
        return list;
    }
}