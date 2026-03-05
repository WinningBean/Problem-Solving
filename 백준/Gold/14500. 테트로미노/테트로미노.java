import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static int[][] dx = {
        // 긴 막대
        {0, 0, 0, 0}, {0, 1, 2, 3},
        // 정사각형
        {0, 0, 1, 1},
        // L형
        {0, 1, 2, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 0, 1, 2}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 1},
        // ㄹ형
        {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, 1, 1}, {0, 0, 1, 1},
        // ㅜ형
        {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 2}, {0, 1, 1, 2}
    };
    static int[][] dy = {
        // 긴 막대
        {0, 1, 2, 3}, {0, 0, 0, 0},
        // 정사각형
        {0, 1, 0, 1},
        // L형
        {0, 0, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 0}, {0, 1, 1, 1}, {0, 1, 2, 0}, {0, 1, 2, 2}, {0, 0, 1, 2}, {2, 0, 1, 2},
        // ㄹ형
        {0, 0, 1, 1}, {1, 0, 1, 0}, {1, 2, 0, 1}, {0, 1, 1, 2},
        // ㅜ형
        {0, 1, 2, 1}, {1, 0, 1, 2}, {0, 0, 1, 0}, {1, 0, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int maxX = Integer.parseInt(NM[0]);
        int maxY = Integer.parseInt(NM[1]);

        int[][] paper = new int[maxX + 3][maxY + 3];
        for (int i = 0; i < maxX; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < maxY; j++) {
                paper[i][j] = line[j];
            }
        }

        int maxSum = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                maxSum = Math.max(maxSum, getTetrominoMaxSum(paper, x, y));
            }
        }

        System.out.print(maxSum);
        br.close();
    }

    static int getTetrominoMaxSum(int[][] paper, int x, int y) {
        int maxSum = 0;
        for (int type = 0; type < dx.length; type++) {
            int sum = 0;
            for (int move = 0; move < 4; move++) {
                sum += paper[x + dx[type][move]][y + dy[type][move]];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}