class Solution {
    public int solution(int hp) {
        int answer = 0;
        int num1 = 0;
		int num2 = 0;
        
		answer = hp / 5;
		num1 = hp % 5;

		if (num1 != 0) {
			answer += num1 / 3;
			num2 = num1 % 3;
		}
		if (num2 != 0) {
			answer += num2;
		}
        return answer;
    }
}