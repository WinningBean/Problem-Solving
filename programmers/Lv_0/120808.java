// 분수의 덧셈
class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int numerator = denum1 * num2 + denum2 * num1;
        int denominator = num1 * num2;
        int gcd = gcd(denominator, numerator);

        numerator /= gcd;
        denominator /= gcd;

        int[] answer = {numerator, denominator};
        return answer;
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}