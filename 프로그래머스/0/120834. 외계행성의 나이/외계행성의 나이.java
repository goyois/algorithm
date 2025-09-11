class Solution {
    public String solution(int age) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		String ageStr = String.valueOf(age);
		String s = "abcdefghijklmnopqrstuvwxyz";


		for (int i = 0; i < ageStr.length(); i++) {
			String str = ageStr.substring(i,i+1);
			int index = Integer.parseInt(str);
			sb.append(s.substring(index,index+1));
		}

		answer = sb.toString();
        return answer;
    }
}