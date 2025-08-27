import java.util.*;


class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> arr = new ArrayList();

        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length; i++){
            arr.add(numbers[i]);
        }
        
        int maxIndex = arr.size() -1;
        answer = arr.get(maxIndex) * arr.get(maxIndex -1); 
        return answer;
    }
}