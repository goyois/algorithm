class Solution {
    public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String answer = "";

		String[] arr = s.split(" ", -1);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				char c = (arr[i].charAt(j));
				if (j == 0 || j % 2 == 0) {
					sb.append(Character.toUpperCase(c));
				} else if (j % 2 == 1) {
					sb.append(Character.toLowerCase(c));
				}
			}
			if (i < arr.length - 1) sb.append(" ");
		}
		answer = sb.toString();
        return answer;
    }
}