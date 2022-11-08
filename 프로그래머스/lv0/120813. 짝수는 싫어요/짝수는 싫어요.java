import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> oddNums = new ArrayList<>();
        for (int i = 1; i <= n; i += 2) {
            oddNums.add(i);
        }
        return oddNums.stream().mapToInt(Integer::intValue).toArray();
    }
}