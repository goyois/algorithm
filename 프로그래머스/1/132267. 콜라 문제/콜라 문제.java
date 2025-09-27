class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
		while (n >= a) {
			int oldCoke = (n / a) * a; 
			int newCoke = (n / a) * b; 
			n -= oldCoke; 
			n += newCoke; 
			answer += newCoke;
	}
        return answer;
    }
}