import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MAX_CASE = 100;
        long[] triangleSideLengths = new long[MAX_CASE + 1];
        for (int i = 1; i < 4; i++) {
            triangleSideLengths[i] = 1;
        }
        triangleSideLengths[4] = 2;
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            if (triangleSideLengths[N] == 0) {
                for (int i = 5; i <= N; i++) {
                    triangleSideLengths[i] = triangleSideLengths[i - 1] + triangleSideLengths[i - 5];
                }
            }

            sb.append(triangleSideLengths[N]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}