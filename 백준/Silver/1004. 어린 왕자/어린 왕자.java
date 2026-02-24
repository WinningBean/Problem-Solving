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
            boolean isStartIn = isInCirCle(startX, startY, c[0], c[1], c[2]);
            boolean isEndIn = isInCirCle(endX, endY, c[0], c[1], c[2]);
            
            // 같은 원 안에 있지 않은 경우 카운트
            if (isStartIn != isEndIn) count++;
        }

        return count;
    }

    // 좌표가 원 내부에 있는지 확인 -> 피타고라스 정리 활용
    static boolean isInCirCle(int x, int y, int cx, int cy, int r) {
        return Math.pow(cx - x, 2) + Math.pow(cy - y, 2) <= Math.pow(r, 2);
    }

    static int getSquare(int n) {
        Math.pow(n, 2);

        if (square[n] == 0) {
            square[n] = n * n;
        }

        return square[n];
    }
}