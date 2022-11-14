class Solution {
    final int DIVISIBLE_NUM = 6;
    public int solution(int n) {
        int lcm = lcm(n, DIVISIBLE_NUM);
        return lcm / DIVISIBLE_NUM;
    }

    private int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}