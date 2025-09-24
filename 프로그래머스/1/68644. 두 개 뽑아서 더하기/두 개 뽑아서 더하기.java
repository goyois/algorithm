import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i != j) {
					int num = numbers[i] + numbers[j];
					set.add(num);
				}
			}
		}
        
        List<Integer> tmpList = new ArrayList<>(set);
		Collections.sort(tmpList);
        
        return tmpList;
    }
}
