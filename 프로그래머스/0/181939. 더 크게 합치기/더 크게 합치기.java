class Solution {
    public int solution(int a, int b) {
		StringBuilder sb = new StringBuilder();

		sb.append(a);
		sb.append(b);
		int n1 = Integer.parseInt(sb.toString());

		sb.delete(0,sb.length());

		sb.append(b);
		sb.append(a);
		int n2 = Integer.parseInt(sb.toString());

		int answer = Math.max(n1,n2);
        return answer;
    }
}