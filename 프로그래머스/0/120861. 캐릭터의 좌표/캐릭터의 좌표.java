class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        
		int xRange = board[0] / 2;
		int yRange = board[1] / 2;
		int xRangeMinus = -xRange;
		int yRangeMinus = -yRange;

		for (int i = 0; i < keyinput.length; i++) {
			if (keyinput[i].equals("left") && answer[0] > xRangeMinus) {
				answer[0] -= 1;
			} else if (keyinput[i].equals("right") && answer[0] < xRange) {
				answer[0] += 1;
			} else if (keyinput[i].equals("up") && answer[1] < yRange) {
				answer[1] += 1;
			} else if (keyinput[i].equals("down") && answer[1] > yRangeMinus) {
				answer[1] -= 1;
			}
		}
        return answer;
    }
}