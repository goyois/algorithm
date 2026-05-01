import java.util.*;

class Solution {
    public int solution(int[][] t) {
        int x = t.length;
        int y = t[x - 1].length;
        
        int[][] dp = new int[x][y];
        dp[0][0] = t[0][0];
        
        for (int i = 0; i < x - 1; i++){
            for (int j = 0; j < t[i].length; j++){
                dp[i + 1][j] = Math.max(dp[i + 1][j], t[i + 1][j] + dp[i][j]);
                dp[i + 1][j + 1] = dp[i][j] + t[i + 1][j + 1];
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int num : dp[x - 1]) answer = Math.max(answer,num);
        return answer;
    }
}