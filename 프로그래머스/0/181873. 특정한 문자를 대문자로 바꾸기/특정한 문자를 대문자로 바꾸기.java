class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();

		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.substring(i,i+1).equals(alp)) {
				char c = my_string.charAt(i);
				sb.append(Character.toUpperCase(c));
			} else
				sb.append(my_string.substring(i,i+1));
		}
        return sb.toString();
    }
}