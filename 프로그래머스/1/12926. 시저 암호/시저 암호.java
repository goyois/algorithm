class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
		
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				sb.append(' ');
			} else if (Character.isUpperCase(s.charAt(i))) {
				char base = 'A';
				char shifted = (char) ((c - base + n) % 26 + base);
				sb.append(shifted);
			} else if (Character.isLowerCase(s.charAt(i))) {
				char base = 'a';
				char shifted = (char) ((c - base + n) % 26 + base);
				sb.append(shifted);
			} else {
				sb.append(c);
			}
		}
    
        return sb.toString();
    }
}