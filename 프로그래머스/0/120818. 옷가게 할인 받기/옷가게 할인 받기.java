class Solution {
    public int solution(int price) {
        int answer = 0;
        
		int salePrice1 = (int) (price - (price * 0.05));
		int salePrice2 = (int) (price - (price * 0.1));
		int salePrice3 = (int) (price - (price * 0.20));


		if (price >= 100000 && price < 300000) {
			answer = salePrice1;
		} else if (price >= 300000 && price < 500000) {
			answer = salePrice2;
		} else if (price >= 500000) {
			answer = salePrice3;
		} else {
			answer = price;
		}
        
        return answer;
    }
}