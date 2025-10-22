class Solution {
    public int solution(String str) {
        int answer = 0;
        for(int i = 0; i < str.length(); i++){
            String s = str.substring(i,i+1);
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}