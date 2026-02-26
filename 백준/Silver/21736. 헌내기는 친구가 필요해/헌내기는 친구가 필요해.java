import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static final char EMTPY = 'O', WALL = 'X', START = 'I', PERSON = 'P';
    static final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;


        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int startX = 0, startY = 0;

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == START) {
                    startX = i;
                    startY = j;
                } 
            }
        }

        answer = getMeetPersonCount(startX, startY);

        System.out.print(answer > 0 ? answer :"TT");
        br.close();
    }

    static int getMeetPersonCount(int x, int y) {
        if (!isInMap(x, y) || visited[x][y] || map[x][y] == WALL) return 0;
        visited[x][y] = true;

        int count = 0;
        for (int i = 0; i < 4; i++) {
            count += getMeetPersonCount(x + dx[i], y + dy[i]);
        }

        count += map[x][y] == PERSON ? 1 : 0;
        return count;
    }

    static boolean isInMap(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= map.length || y >= map[0].length) return false;
        return true;
    }
}