import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int stairsCnt = Integer.parseInt(br.readLine());
        int[] stairsScores = new int[stairsCnt];
        for (int i = 0; i < stairsCnt; i++) {
            stairsScores[i] = Integer.parseInt(br.readLine());
        }

        int[][] maxScores = new int[2][stairsCnt];
        maxScores[0][0] = maxScores[1][0] = stairsScores[0];
        if (stairsCnt > 1) {
            maxScores[0][1] = stairsScores[0] + stairsScores[1];
            maxScores[1][1] = stairsScores[1];
        }
        for (int i = 2; i < stairsCnt; i++) {
            maxScores[0][i] = maxScores[1][i - 1] + stairsScores[i];
            maxScores[1][i] = Math.max(maxScores[0][i - 2], maxScores[1][i - 2]) + stairsScores[i];
        }

        sb.append(Math.max(maxScores[0][stairsCnt - 1], maxScores[1][stairsCnt - 1]));

        System.out.println(sb);
        br.close();
    }
}