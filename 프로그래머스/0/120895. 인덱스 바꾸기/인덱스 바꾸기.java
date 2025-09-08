class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        
        char[] arr = my_string.toCharArray();
        char c1 = arr[num1];
        char c2 = arr[num2];
        
        for(int i = 0; i < arr.length; i++){
            if (i == num1){
                arr[i] = c2;
            } else if (i == num2){
                arr[i] = c1;
            }
            
            sb.append(arr[i]);
        }
        
        String answer = sb.toString();
        return answer;
    }
}