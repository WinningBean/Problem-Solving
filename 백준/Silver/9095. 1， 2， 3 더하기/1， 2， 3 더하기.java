import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MAX_NUM = 10;

        int[] numOfWays = new int[MAX_NUM + 1];
        numOfWays[1] = 1;
        numOfWays[2] = 2;
        numOfWays[3] = 4;
        for (int i = 4; i <= MAX_NUM; i++) {
            for (int j = 1; j <= 3; j++) {
                numOfWays[i] += numOfWays[i - j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(numOfWays[num]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}