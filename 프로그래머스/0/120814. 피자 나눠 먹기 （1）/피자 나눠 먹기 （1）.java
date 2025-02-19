class Solution {
    final int DIVISIBLE_NUM = 7;
    public int solution(int n) {
        int needPizza = n / DIVISIBLE_NUM;
        if (n % DIVISIBLE_NUM > 0) {
            needPizza++;
        }
        return needPizza;
    }
}