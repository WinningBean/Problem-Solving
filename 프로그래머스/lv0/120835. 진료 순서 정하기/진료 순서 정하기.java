import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] sortEmergency = emergency.clone();
        Arrays.sort(sortEmergency);
        int length = emergency.length;
        int[] rankingArr = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (rankingArr[i] == 0 && emergency[i] == sortEmergency[j]) {
                    rankingArr[i] = length - j;
                    break;
                }
            }
        }

        return rankingArr;
    }
}