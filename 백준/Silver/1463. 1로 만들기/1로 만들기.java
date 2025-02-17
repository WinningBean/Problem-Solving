import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] minCnts = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            minCnts[i] = minCnts[i - 1] + 1;

            if (i % 2 == 0) {
                minCnts[i] = Math.min(minCnts[i], minCnts[i / 2] + 1);
            }

            if (i % 3 == 0) {
                minCnts[i] = Math.min(minCnts[i], minCnts[i / 3] + 1);
            }
        }

        sb.append(minCnts[N]);

        System.out.println(sb);
        br.close();
    }
}