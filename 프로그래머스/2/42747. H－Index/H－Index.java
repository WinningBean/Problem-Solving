import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);        
        int answer = citations.length;
        
        for (int citation : citations) {
            if (citation >= answer) return answer;
            answer--;
        }
        
        return answer;
    }
}