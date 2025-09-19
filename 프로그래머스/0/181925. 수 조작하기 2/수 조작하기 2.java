class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
		for (int i = 1; i < numLog.length; i++) {
			float n1 = numLog[i - 1];
			float n2 = numLog[i];
            
			if (n1 - n2 == -1) {
				answer += "w";
			} else if (n1 - n2 == 1) {
				answer += "s";
			} else if (n1 - n2 == -10) {
				answer += "d";
			} else if (n1 - n2 == 10) {
				answer += "a";
			}
		}
        return answer;
    }
}