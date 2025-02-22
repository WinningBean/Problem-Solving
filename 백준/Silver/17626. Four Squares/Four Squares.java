import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] squareNums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                squareNums[i] = 1;
            } else {
                squareNums[i] = 4;
                for (int j = 1; j < Math.sqrt(i); j++) {
                    squareNums[i] = Math.min(squareNums[i], squareNums[i - (int) Math.pow(j, 2)] + 1);
                    if (squareNums[i] == 2) break;
                }
            }
        }

        sb.append(squareNums[n]);

        System.out.println(sb);
        br.close();
    }
}