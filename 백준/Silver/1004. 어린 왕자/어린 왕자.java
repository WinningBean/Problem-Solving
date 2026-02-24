import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static int[] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        square = new int[1001];

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int n = Integer.parseInt(br.readLine());
            int[][] circle = new int[n][3];
            for (int i = 0; i < n; i++) {
                circle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }


            sb.append(
                getAnswer(Arrays.copyOfRange(xy, 0, 2),
                    Arrays.copyOfRange(xy, 2, 4),
                    circle))
                .append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }

    static int getAnswer(int[] start, int[] end, int[][] circle) {
        int startX = start[0], startY = start[1];
        int endX = end[0], endY = end[1];

        int count = 0;

        for (int[] c : circle) {
            int cx = c[0];
            int cy = c[1];
            int radiusSquare = getSquare(c[2]);

            boolean isStartIn = isIn(startX, startY, cx, cy, c[2], radiusSquare);
            boolean isEndIn = isIn(endX, endY, cx, cy, c[2], radiusSquare);
            
            // 같은 원 안에 있지 않은 경우 카운트
            if (isStartIn != isEndIn) count++;
        }

        return count;
    }

    // 좌표가 원 내부에 있는지 확인 -> 피타고라스 정리 활용
    static boolean isIn(int x, int y, int cx, int cy, int r, int radiusSquare) {
        int centerToX = Math.abs(cx - x);
        int centerToY = Math.abs(cy - y);

        if (centerToX > r || centerToY > r) return false;
        return getSquare(centerToX) + getSquare(centerToY) <= radiusSquare;
    }

    static int getSquare(int n) {
        if (square[n] == 0) {
            square[n] = n * n;
        }

        return square[n];
    }
}