import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
		ArrayList<String> list = new ArrayList<>();
		int size = 0;
		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].contains("ad")) {
				list.add(strArr[i]);
				size++;
			}
		}
		String[] answer = new String[size];
		list.toArray(answer);
        return answer;
    }
}