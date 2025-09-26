class Solution {
    public int solution(int i, int j, int k) {
		int answer = 0;
		String str = String.valueOf(k);

		for (int n = i; n <= j; n++){
			String s = String.valueOf(n);
			String[] arr = s.split("");
			for (String sx : arr) {
				if (sx.equals(str)){
					answer++;
				}
			}
		}

        return answer;
    }
}