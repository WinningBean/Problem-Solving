import java.util.*;

class Solution {
    int goalX, goalY;
    public int solution(int[][] maps) {
        int goalX = maps.length - 1;
        int goalY = maps[0].length - 1;
        
        int[][] steps = new int[maps.length][maps[0].length];
        steps[0][0] = maps[0][0];
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int x = 0, y = 0;
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y));
        
        while (!q.isEmpty()) {
            Position here = q.poll();
            x = here.x;
            y = here.y;
            
            int nextStep = steps[x][y] + 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx > goalX || ny > goalY) continue;
                if (maps[nx][ny] == 0 || steps[nx][ny] > 0) continue;
                
                steps[nx][ny] = nextStep;
                q.offer(new Position(nx, ny));
            }
        }
        
        int result = steps[goalX][goalY] == 0 ? -1 : steps[goalX][goalY];
        
        return result;
    }
}

class Position {
    int x;
    int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}