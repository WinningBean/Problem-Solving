import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static int N;
    static int[][] baconNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        baconNums = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(baconNums[i], Integer.MAX_VALUE);
            baconNums[i][i] = 0;
        }
        
        while (M-- > 0) {
            String[] connection = br.readLine().split(" ");
            int A = Integer.parseInt(connection[0]);
            int B = Integer.parseInt(connection[1]);
            baconNums[A][B] = baconNums[B][A] = 1;
        }

        setBaconNums();

        int minBaconNum = Integer.MAX_VALUE;
        int minBaconNumId = 0;
        for (int i = 1; i <= N; i++) {
            int baconNum = 0;
            for (int j = 1; j <= N; j++) {
                baconNum += baconNums[i][j];
            }
            if (minBaconNum > baconNum) {
                minBaconNum = baconNum;
                minBaconNumId = i;
            }
        }

        System.out.print(minBaconNumId);
        br.close();
    }

    static void setBaconNums() {
        // 거쳐가는 정점
        for (int k = 1; k <= N; k++) {
            // 시작점
            for (int i = 1; i <= N; i++) {
                // 거쳐가지 못하는 경우 패스
                if (baconNums[k][i] == Integer.MAX_VALUE || k == i) continue;
                // 끝점
                for (int j = 1; j <= N; j++) {
                    // 거쳐가지 못하는 경우 패스
                    if (baconNums[k][j] == Integer.MAX_VALUE || i == j) continue;
                    baconNums[i][j] = Math.min(baconNums[i][j], baconNums[i][k] + baconNums[k][j]);
                }
            }
        }
    }
}