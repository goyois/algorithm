import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();

		for (int n : arr) {
			list.add(n);
		}

		Collections.sort(list);
		list.remove(0);


		if (arr.length == 1) {
			answer.add(-1);
		} else if (arr.length != 1) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < list.size(); j++) {
					if (arr[i] == list.get(j)) {
						answer.add(arr[i]);
					}
				}
			}
		}

        return answer;
    }
}