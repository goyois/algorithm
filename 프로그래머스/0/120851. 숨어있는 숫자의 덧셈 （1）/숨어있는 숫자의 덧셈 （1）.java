class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
		String intStr = my_string.replaceAll("[^0-9]", "");
		for (int i = 0; i < intStr.length(); i++) {
			answer += Character.getNumericValue(intStr.charAt(i));
		}
        
        return answer;
    }
}