class Solution {
    public int solution(int n) {
        
        int piz = 6;
        int answer = 0;
        
        for(int i = 1; i <= n * piz; i++){
            if (piz * i % n == 0){
                answer = i;
                break;
            }
        }
    
        
        return answer;
    }
}