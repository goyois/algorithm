class Solution {
    public String solution(String myString) {
        String answer = "";
		myString = myString.replace('a','A');
		for (int i = 0; i < myString.length(); i++) {
			char c = myString.charAt(i);
			if (c != 'A' && Character.isUpperCase(c)) answer += Character.toLowerCase(c);
			 else answer += c;
		}
        return answer;
    }
}