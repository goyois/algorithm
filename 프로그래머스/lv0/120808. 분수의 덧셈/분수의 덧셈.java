class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {        
        int a = denom1 * numer2 + denom2 * numer1;
        int b = denom1 * denom2;
        
        for (int i = a-1; i > 1; i--){
            if(a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        int [] result = {a , b};
        return result;
    }
}
    


