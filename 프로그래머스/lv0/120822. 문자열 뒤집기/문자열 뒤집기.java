class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(my_string);
        String rv = sb.reverse().toString();
        return rv + answer;
        
    }
}