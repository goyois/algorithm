class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				answer = false;
				break;
			}
		}
		
		if (s.length() != 4 && s.length() != 6) {
			answer = false;
		}
        return answer;
    }
}