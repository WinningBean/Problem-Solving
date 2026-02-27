import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] nowArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(nowArr);
            
            answer[l] = nowArr[k - 1];
        }
        
        return answer;
    }
}