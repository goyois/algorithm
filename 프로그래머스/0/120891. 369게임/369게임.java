class Solution {
    public int solution(int order) {
		int answer = 0;
		String orderStr = String.valueOf(order);
		
		for (int i = 0; i < orderStr.length(); i++) {
			int o = Integer.parseInt(orderStr.substring(i,i+1));
			if (o == 3 || o == 6 || o == 9) {
				answer++;
			}
		}
        return answer;
    }
}