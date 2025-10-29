class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        
        for (int rt = 0; rt < n; rt++){
            sum += arr[rt];
            if (sum == n) answer++;
            while(sum >= n){
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }
        
        
        return answer;
    }
}