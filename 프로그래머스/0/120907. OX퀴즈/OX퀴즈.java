class Solution {
    public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];
		int x = 0;
		int y = 0;
		int z = 0;
		String operator = "";


		for (int i = 0; i < quiz.length; i++) {
			String[] str = quiz[i].split(" ");
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[2]);
			z = Integer.parseInt(str[4]);
			operator = str[1];

			if (operator.equals("+")){
				if (x + y == z) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			} else if (operator.equals("-")) {
				if (x - y == z) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			}
        }
        return answer;
    }
}