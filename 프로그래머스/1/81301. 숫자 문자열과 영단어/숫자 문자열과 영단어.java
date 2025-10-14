import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

		String[] arr = {
				"zero", "one", "two", "three","four",
				"five","six","seven","eight","nine"};
        
		HashMap<String,Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(arr[i],i);
		}

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) sb.append(s.charAt(i));
			 else for (int j = i+1; j <= s.length(); j++) {
					String sub = s.substring(i,j);
					try {
						if (!map.get(sub).equals(null))
							sb.append(map.get(sub));
							break;
					} catch (NullPointerException e) {
						continue;
					}
				}
		}
		answer = Integer.parseInt(sb.toString());
        return answer;
    }
}