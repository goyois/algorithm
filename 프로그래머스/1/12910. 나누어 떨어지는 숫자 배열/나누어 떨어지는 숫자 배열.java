import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
		int size = 1;
        
		for (int num : arr) {
			if (num % divisor == 0) {
				size++;
			}
		}
        
		int[] answer = new int[size];
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				answer[idx] = arr[i];
				idx++;
			} else if (idx == 0) {
				answer[idx] = -1;
			}
		}

		Arrays.sort(answer);
        return answer;
    }
}