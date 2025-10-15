import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		ArrayList<Integer> list = new ArrayList<>();

        if (k >= score.length){
            for (int i = 0; i < score.length; i++) {
                list.add(score[i]);
                answer[i] = Collections.min(list);
            }
            return answer;
        } else {   
		for (int i = 0; i < k; i++) {
			list.add(score[i]);
			answer[i] = Collections.min(list);
		}
		Collections.sort(list,Collections.reverseOrder());
		for (int i = k; i < score.length; i++) {
			if (score[i] >= list.get(k - 1)) {
				list.add(score[i]);
				Collections.sort(list, Collections.reverseOrder());
				list.remove(list.size() - 1);
				answer[i] = Collections.min(list);
			} else {
				answer[i] = Collections.min(list);
			}
		}
        return answer;
        }
    }
}