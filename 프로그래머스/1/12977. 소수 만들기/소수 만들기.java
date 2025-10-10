class Solution {
    public int solution(int[] nums) {
		int answer = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					int tmp = nums[i] + nums[j] + nums[k];

					if (tmp % 2 != 0) {
						int cnt = 0;
						for (int l = 2; l <= tmp; l++) {
							if (tmp % l == 0)
								cnt++;
						}
						if (cnt == 1) answer++;
					}
				}
			}
		}


        return answer;
    }
}