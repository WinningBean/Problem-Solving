import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static boolean[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        paper = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                paper[i][j] = line[j] == 1;
            }
        }

        int[] whiteBluteCount = countWhiteBluePaper(0, 0, N);
        sb.append(whiteBluteCount[0]).append("\n").append(whiteBluteCount[1]);
        
        System.out.print(sb);
        br.close();
    }

    static int[] countWhiteBluePaper(int x, int y, int range) {
        int[] whiteBluteCount = new int[2];
        if (range == 1) {
            whiteBluteCount[paper[x][y] ? 1 : 0]++;
            return whiteBluteCount;
        }

        // 4분면으로 나눠서 각 종이 색상을 확인
        int half = range / 2;
        for (int i = x; i < x + range; i += half) {
            for (int j = y; j < y + range; j += half) {
                int[] piecewhiteBluteCount = countWhiteBluePaper(i, j, half);
                whiteBluteCount[0] += piecewhiteBluteCount[0];
                whiteBluteCount[1] += piecewhiteBluteCount[1];
            }
        }

        // 각 4분면이 모두 같은 색이면 하나로 통합
        if (whiteBluteCount[0] == 4 && whiteBluteCount[1] == 0) whiteBluteCount[0] = 1;
        else if (whiteBluteCount[1] == 4 && whiteBluteCount[0] == 0) whiteBluteCount[1] = 1;

        return whiteBluteCount;
    }
}