class Solution {
    public int[] solution(int[] emergency) {
        int length = emergency.length;
        int[] rankingArr = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (emergency[i] <= emergency[j]) {
                    rankingArr[i]++;
                }
            }
        }

        return rankingArr;
    }
} 