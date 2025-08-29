class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        for(int i = 0; i < str.length(); i++){
            int x = Integer.valueOf(str.substring(i,i+1));
            answer += x;
        }
        
        return answer;
    }
}