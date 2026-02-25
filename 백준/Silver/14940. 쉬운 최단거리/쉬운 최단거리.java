import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static int[][] map, distanceMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 & 초기화
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int destinationX = 0, destinationY = 0;
        map = new int[n][m];
        distanceMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) {
                    distanceMap[i][j] = -1;
                } else if (map[i][j] == 2) {
                    destinationX = i;
                    destinationY = j;
                    distanceMap[i][j] = 0;
                }
            }
        }

        // 구현
        int[][] distanceMap = getDistanceMap(destinationX, destinationY);

        // 출력
        for (int[] line : distanceMap) {
            for (int spot : line) {
                sb.append(spot).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static int[][] getDistanceMap(int destinationX, int destinationY) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{destinationX, destinationY});

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0], y = xy[1];

            int nextDistance = distanceMap[x][y] + 1;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i], nextY = y + dy[i];
                if (isInMap(nextX, nextY) && distanceMap[nextX][nextY] == -1) {
                    distanceMap[nextX][nextY] = nextDistance;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return distanceMap;
    }

    static boolean isInMap(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= map.length || y >= map[0].length) return false;
        return true;
    }
}