import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] coins = new int[N];
        
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int checkIdx = N - 1;
        while (K > 0) {
            if (K >= coins[checkIdx]) {
                result += K / coins[checkIdx];
                K %= coins[checkIdx];
            }
            checkIdx--;
        }

        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}