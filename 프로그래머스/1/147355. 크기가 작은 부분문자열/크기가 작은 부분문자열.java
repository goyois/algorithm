class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long num = 0;
        int length = p.length();
        
		for (int i = 0; i <= t.length() - length; i++) {
			num = Long.parseLong(t.substring(i,i + length));
			if (Long.parseLong(p) >= num) {
				answer++;
			}
        }
        
        return answer;
    }
}