class Solution {
    private final int AMERICANO_PRICE = 5500;

    public int[] solution(int money) {
        int possibleCup =  money / AMERICANO_PRICE;
        int leftMoney = money % AMERICANO_PRICE;

        int[] answer = {possibleCup, leftMoney};
        return answer;
    }
}