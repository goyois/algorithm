class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String str = "";
		int size = 0;

		for (int i = 0; i < myString.length(); i++){
			char c = myString.charAt(i);
			if (c == 'A') {c = 'B';}
			else c = 'A';
			str += c;
		}

		if (str.length() != pat.length()) {
			size = str.length() - pat.length();
		}

		for (int i = 0; i <= size; i++) {
			if (str.substring(i, i+pat.length()).equals(pat)) {
				answer = 1;
			}
		}
        
        return answer;
    }
}