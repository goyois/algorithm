class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = code; i <= cipher.length(); i++){
            if(i % code == 0){
                sb.append(cipher.charAt(i -1));
            }
        }
        String answer = sb.toString();
        return answer;
    }
}