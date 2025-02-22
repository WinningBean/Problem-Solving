import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MOD_NUM = 10007;

        int n = Integer.parseInt(br.readLine());
        int[] sumArr = new int[n + 1];
        sumArr[1] = 1;
        if (n > 1) sumArr[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            sumArr[i] = sumArr[i - 2] + sumArr[i - 1];

            if (sumArr[i] > MOD_NUM) {
                sumArr[i] %= MOD_NUM;
            }
        }

        sb.append(sumArr[n]);

        System.out.println(sb);
        br.close();
    }
}