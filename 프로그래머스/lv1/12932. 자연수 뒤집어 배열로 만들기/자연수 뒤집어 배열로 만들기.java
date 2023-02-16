class Solution {
    public int[] solution(long n) {
        String s = "" + n;
        
        int[] arr = new int[s.length()];
        int count = 0;
        
        while(n > 0){
            arr[count] = (int) (n % 10);
            n /= 10;
            count++;
        } return arr;
    }
}