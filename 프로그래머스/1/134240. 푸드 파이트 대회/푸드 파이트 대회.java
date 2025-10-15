class Solution {
    public String solution(int[] food) {
		StringBuilder answer = new StringBuilder();

		for (int i = 1; i < food.length; i++) {
			for (int j = 0; j < food[i] / 2; j++) {
				answer.append(i);
			}
		}
		StringBuilder sb = new StringBuilder(answer).reverse();
		answer.append("0" + sb);
        return answer.toString();
    }
}