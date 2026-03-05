import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static int maxX, maxY;
    static int[][] paper;

    static int[][] dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        maxX = Integer.parseInt(NM[0]);
        maxY = Integer.parseInt(NM[1]);

        paper = new int[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                maxSum = Math.max(maxSum, getTetromino1MaxSum(x, y));
                maxSum = Math.max(maxSum, getTetromino2MaxSum(x, y));
                maxSum = Math.max(maxSum, getTetromino3MaxSum(x, y));
                maxSum = Math.max(maxSum, getTetromino4MaxSum(x, y));
                maxSum = Math.max(maxSum, getTetromino5MaxSum(x, y));
            }
        }

        System.out.print(maxSum);
        br.close();
    }

    /// 긴 막대
    static int getTetromino1MaxSum(int x, int y) {
        int maxSum = 0;

        dx = new int[][]{{0, 0, 0, 0}, {0, 1, 2, 3}};
        dy = new int[][]{{0, 1, 2, 3}, {0, 0, 0, 0}};

        for (int type = 0; type < dx.length; type++) {
            int sum = 0;
            for (int move = 0; move < 4; move++) {
                if (isInPaper(x + dx[type][move], y + dy[type][move])) {
                    sum += paper[x + dx[type][move]][y + dy[type][move]];
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /// 정사각형
    static int getTetromino2MaxSum(int x, int y) {
        int maxSum = 0;

        dx = new int[][]{{0, 0, 1, 1}};
        dy = new int[][]{{0, 1, 0, 1}};

        for (int type = 0; type < dx.length; type++) {
            int sum = 0;
            for (int move = 0; move < 4; move++) {
                if (isInPaper(x + dx[type][move], y + dy[type][move])) {
                    sum += paper[x + dx[type][move]][y + dy[type][move]];
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /// L형
    static int getTetromino3MaxSum(int x, int y) {
        int maxSum = 0;

        dx = new int[][]{{0, 1, 2, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 0, 1, 2}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 1}};
        dy = new int[][]{{0, 0, 0, 1}, {0, 0, 0, -1}, {0, 1, 0, 0}, {0, 1, 1, 1}, {0, 1, 2, 0}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, -2, -1, 0}};

        for (int type = 0; type < dx.length; type++) {
            int sum = 0;
            for (int move = 0; move < 4; move++) {
                if (isInPaper(x + dx[type][move], y + dy[type][move])) {
                    sum += paper[x + dx[type][move]][y + dy[type][move]];
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /// ㄹ형
    static int getTetromino4MaxSum(int x, int y) {
        int maxSum = 0;

        dx = new int[][]{{0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        dy = new int[][]{{0, 0, 1, 1}, {0, -1, 0, -1}, {-1, 0, -2, -1}, {0, 1, 1, 2}};

        for (int type = 0; type < dx.length; type++) {
            int sum = 0;
            for (int move = 0; move < 4; move++) {
                if (isInPaper(x + dx[type][move], y + dy[type][move])) {
                    sum += paper[x + dx[type][move]][y + dy[type][move]];
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /// ㅜ형
    static int getTetromino5MaxSum(int x, int y) {
        int maxSum = 0;

        dx = new int[][]{{0, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 2}, {0, 1, 1, 2}};
        dy = new int[][]{{0, 1, 2, 1}, {0, -1, 0, 1}, {0, 0, 1, 0}, {0, -1, 0, 0}};

        for (int type = 0; type < dx.length; type++) {
            int sum = 0;
            for (int move = 0; move < 4; move++) {
                if (isInPaper(x + dx[type][move], y + dy[type][move])) {
                    sum += paper[x + dx[type][move]][y + dy[type][move]];
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    static boolean isInPaper(int x, int y) {
        if (x < 0 || y < 0 || x >= maxX || y >= maxY) return false;
        return true;
    }
}