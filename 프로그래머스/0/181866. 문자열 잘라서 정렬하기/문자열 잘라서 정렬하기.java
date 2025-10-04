import java.util.*;

class Solution {
    public String[] solution(String myString) {
		String[] arr = myString.split("x");
		ArrayList<String> list = new ArrayList<>();
		for (String s : arr) {
			if (!s.isEmpty()) {
				list.add(s);
			}
		}
		String[] answer = new String[list.size()];
		list.toArray(answer);
		Arrays.sort(answer);
        
        return answer;
    }
}