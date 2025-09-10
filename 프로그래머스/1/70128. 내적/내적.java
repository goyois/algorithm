class Solution {
    public int solution(int[] a, int[] b) {
		int size = 0;
		int answer = 0;

		if (a.length < b.length) {
			size = b.length;
		} else if (a.length > b.length){
			size = a.length;
		} else {
			size = a.length;
		}
        
		for (int i = 0; i < size; i++) {
			answer += a[i] * b[i];
		}
        return answer;
    }
}