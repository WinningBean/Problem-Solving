import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    final int RANGE = 1000;
    public int solution(int[] array) {
        int cnt[] = new int[RANGE];
        int maxCnt = 0;
        int maxCntNum = 0;

        for (int num : array) {
            if (++cnt[num] > maxCnt) {
                maxCnt = cnt[num];
                maxCntNum = num;
            }
        }

        List<Integer> cntList = Arrays.stream(cnt).boxed().collect(Collectors.toList());
        int maxCntFrequency = Collections.frequency(cntList, maxCnt);
        if (maxCntFrequency == 1) {
            return maxCntNum;
        }
        return -1;
    }
}