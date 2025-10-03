import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] query) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.stream(arr)
				.boxed()
				.collect(Collectors.toList()));
		
        for (int i = 0; i < query.length; i++){
            if (i % 2 == 0){
                list.subList(query[i]+1,list.size())
                    .clear();
            } else {list.subList(0,query[i])
                .clear();
            }
        }	
        
		int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return answer;
    }
}