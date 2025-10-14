import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] result = new int[photo.length];
		HashMap<String,Integer> map = new HashMap<>();
		for (int i = 0; i < name.length; i++) {
			map.put(name[i],yearning[i]);
		}
		for (int i = 0; i < photo.length; i++) {
			int n = 0;
			for (int j = 0; j < photo[i].length; j++) {
				try {
					n += (int) map.get(photo[i][j]);
				} catch (NullPointerException e) {
					continue;
				}
			}
			result[i] = n;
		}
        return result;
    }
}