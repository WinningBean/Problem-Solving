import java.util.*;

class Solution {
    boolean[] visited;
    int[][] copyDungeons;
    
    public int solution(int k, int[][] dungeons) {
        int length = dungeons.length;
        visited = new boolean[length];
        copyDungeons = dungeons.clone();
        
        int maxCount = getMaxDungeon(k);
        
        return maxCount;
    }
    
    int getMaxDungeon(int health) {
        int maxCount = 0;
        for (int i = 0; i < copyDungeons.length; i++) {
            if (visited[i] || copyDungeons[i][0] > health) continue;
            visited[i] = true;
            
            int min = copyDungeons[i][0];
            int waste = copyDungeons[i][1];
            
            int count = getMaxDungeon(health - waste) + 1;
            maxCount = Math.max(maxCount, count);
            
            visited[i] = false;
        }
        
        return maxCount;
    }
}