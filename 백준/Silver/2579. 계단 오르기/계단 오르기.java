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

        int[] maxScores = new int[stairsCnt];
        maxScores[0] = stairsScores[0];
        if (stairsCnt > 1) {
            maxScores[1] = stairsScores[0] + stairsScores[1];
        }
        if (stairsCnt > 2) {
            maxScores[2] = Math.max(stairsScores[0], stairsScores[1]) + stairsScores[2];
        }

        for (int i = 3; i < stairsCnt; i++) {
            maxScores[i] = Math.max(maxScores[i - 2], maxScores[i - 3] + stairsScores[i - 1]) + stairsScores[i];
        }

        sb.append(maxScores[stairsCnt - 1]);

        System.out.println(sb);
        br.close();
    }
}