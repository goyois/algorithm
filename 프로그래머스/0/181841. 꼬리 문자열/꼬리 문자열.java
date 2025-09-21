class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str_list.length; i++){
            sb.append(str_list[i].indexOf(ex) == -1 ? str_list[i] : "");
        }
        
        return sb.toString();
    }
}