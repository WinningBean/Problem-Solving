class Solution {
    final int LAMB_SKEWERS_PRICE = 12000;
    final int DRINK_PRICE = 2000;

    public int solution(int n, int k) {
        int totalPrice = 0;
        totalPrice += LAMB_SKEWERS_PRICE * n;
        totalPrice += DRINK_PRICE * k;
        totalPrice -= n / 10 * DRINK_PRICE;

        return totalPrice;
    }
}