import java.util.*;


class Solution {
    public String solution(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
			map.put(key,map.getOrDefault(key,0) + 1);
		}

		ArrayList<Character> list = new ArrayList<>();

		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() == 1) {
				list.add(e.getKey());
			}
		}
		Collections.sort(list);

		for (char c : list) {
			sb.append(c);
		}
        String answer = sb.toString();
        return answer;
    }
}