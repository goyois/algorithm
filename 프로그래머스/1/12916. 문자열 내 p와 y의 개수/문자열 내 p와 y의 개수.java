class Solution {
    boolean solution(String s) {
        boolean answer = true;
		int cntP = 0;
		int cntY = 0;

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c.equals('P') || c.equals('p')) {
				cntP ++;
			} else if (c.equals('Y') || c.equals('y')) {
				cntY ++;
			}
		}

		if (cntP != cntY) {
			answer = false;
		}
        return answer;
    }
}