import java.util.*;

class Solution {
    public int solution(String[] strArr) {
		Integer[] lengthArr = new Integer[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			lengthArr[i] = strArr[i].length();
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int x : lengthArr) {
			map.put(x,map.getOrDefault(x,0) +1);
		}

		int max = Integer.MIN_VALUE;
		for (Map.Entry<Integer,Integer> x : map.entrySet()) {
			if (x.getValue() > max) {
				max = x.getValue();
			}
		}
        
        return max;
    }
}