class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++){
            if(!String.valueOf(my_string.charAt(i)).equals(letter)){
                sb.append(my_string.charAt(i));
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}