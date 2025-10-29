class Solution {
    public int solution(int[] num_list) {
        int answer = 1;
        int len = num_list.length;
        
        for (int i = 0; i < num_list.length; i++){
            if (len >= 11){
                answer += num_list[i];
            } else {
                answer *= num_list[i];
            }
        }

        if (len >= 11) answer = answer -1;
        return answer;
    }
}