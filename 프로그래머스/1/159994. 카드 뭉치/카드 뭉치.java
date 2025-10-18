class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";
		int p1= 0; int p2 = 0;

		for (String g : goal) {
			if (p1 < cards1.length && cards1[p1].equals(g)) {
				p1++;
			} else if (p2 < cards2.length && cards2[p2].equals(g)) {
				p2++;
			} else {
				answer = "No";
			}
		}
        return answer;
    }
}