class Solution {
    public boolean solution(int x) {
        boolean answer = true;
		int result = 0;
        
		String s = String.valueOf(x);
		for (int i = 0; i < s.length(); i++) {
			result += Integer.parseInt(s.substring(i,i+1));
		}
		if (x % result != 0) {
			answer = false;
		}
        return answer;
    }
}