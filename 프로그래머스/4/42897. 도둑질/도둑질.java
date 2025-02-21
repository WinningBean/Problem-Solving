class Solution {
    public int solution(int[] money) {
        int houseNum = money.length;
        int[] maxMoneyArr1 = new int[houseNum + 1];
        int[] maxMoneyArr2 = new int[houseNum + 1];
        maxMoneyArr1[houseNum - 2] = money[houseNum - 2];
        maxMoneyArr2[houseNum - 1] = money[houseNum - 1];
        maxMoneyArr2[houseNum - 2] = money[houseNum - 2];
        
        for (int i = houseNum - 3; i >= 0; i--) {
            maxMoneyArr1[i] = Math.max(maxMoneyArr1[i + 2], maxMoneyArr1[i + 3]) + money[i];
            maxMoneyArr2[i] = Math.max(maxMoneyArr2[i + 2], maxMoneyArr2[i + 3]) + money[i];
        }
        
        int maxMoneyStart1 = Math.max(maxMoneyArr1[0], maxMoneyArr1[1]);
        int amxMoneyStart2 = Math.max(maxMoneyArr2[1], maxMoneyArr2[2]);
        
        int result = Math.max(maxMoneyStart1, amxMoneyStart2);
        return result;
    }
}