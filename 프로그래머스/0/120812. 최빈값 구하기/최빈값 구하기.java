import java.util.*;

class Solution {
    public int solution(int[] array) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int answer = 0;
        
		for (int i = 0; i < array.length; i++) {
			map.put(array[i],map.getOrDefault(array[i], 0) + 1);
		}
        
		int num = 0;
		int key = 0;
		boolean bool = false;

		for (int k : map.keySet()) {
			int v = map.get(k);

			if (v > num) {
				num = v;
				key = k;
				bool = false;
			} else if (v == num) {
				bool = true;
			}
			answer =  bool ? -1 : key;
		}
        return answer;
    }
}