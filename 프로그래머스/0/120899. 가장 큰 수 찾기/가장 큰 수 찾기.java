import java.util.*;

class Solution {
    public int[] solution(int[] array) {
		int[] arr = {0,0};
		arr[0] = Arrays.stream(array).max().getAsInt();
        
		for (int i = 0; i < array.length; i++) {
			if (arr[0] == array[i]) {
				arr[1] = i;
			}
		}
        return arr;
    }
}