import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int maxWork = Arrays.stream(works).max().getAsInt();
        int[] worksCnt = new int[maxWork + 1];
        for (int work : works) {
            worksCnt[work]++;
        }
        
        for (int i = maxWork; i > 0; i--) {
            if (worksCnt[i] >= n) {
                worksCnt[i - 1] += n;
                worksCnt[i] -= n;
                break;
            } else {
                n -= worksCnt[i];
                worksCnt[i - 1] += worksCnt[i];
                worksCnt[i] = 0;
            }
        }
        
        for (int i = 1; i <= maxWork; i++) {
            answer += Math.pow(i, 2) * worksCnt[i];
        }
        
        return answer;
    }
}