import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			for (int j = 0; j < 1; j++) {
				int start = commands[i][j];
				int end = commands[i][j+1];
				int num = commands[i][j+2];
				for (int k = start-1; k < end; k++) {
					list.add(array[k]);
				}
				Collections.sort(list);
				answer[i] = list.get(num -1);
				list.clear();
			}
		}
        return answer;
    }
}