class Solution {
    public int solution(int n) {
        int biggestNum = n % 2 == 0 ? n : n - 1;
        int evenSum = (2 + biggestNum) * biggestNum / 4;

        return evenSum;
    }
}