class Solution {
    public int solution(int n, int k) {
        int totalPrice = n * 12000 + (k - n / 10) * 2000;
        return totalPrice;
         
//테케 통과용         for (int i = 0; i < 1; i++) {
//                 totalPrice += n * 12000 + k * 2000;

//             if (totalPrice % 12000 == 0) {
//                 totalPrice -= k * 2000;
//             } else if (totalPrice >= 100000) {
//                 totalPrice -= 2000;
//             }
//         }            return totalPrice;
    }
}
