class Solution {
    public String solution(String my_string, int s, int e) {
		String answer = "";
		String str = my_string.substring(0,s);
		StringBuilder sb = new StringBuilder(my_string.substring(s,e+1)).reverse();
        
		answer = str + sb.toString();
		for (int i = e + 1; i < my_string.length(); i++) {
			answer += my_string.charAt(i);
		}
        return answer;
    }
}