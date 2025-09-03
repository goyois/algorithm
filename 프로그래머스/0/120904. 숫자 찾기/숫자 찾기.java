class Solution {
    public int solution(int num, int k) {
		int answer = -1;
		String str1 = String.valueOf(k);
		String str2 = String.valueOf(num);
		int index = str2.indexOf(str1);

		if (index != -1) {
			answer = index + 1;
		}
    
        return answer;
    }
}