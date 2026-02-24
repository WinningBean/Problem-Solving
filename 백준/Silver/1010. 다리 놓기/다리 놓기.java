import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String info[] = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int M = Integer.parseInt(info[1]);

            sb.append(getCombination(M, N))
                .append("\n");
        }

        System.out.print(sb);
        
        br.close();
    }

    static int getCombination(int n, int r) {
        if (r > 1) {
            return n * getCombination(n - 1, r - 1) / r;
        }

        int value = 1;
        for (int i = n; i > n - r; i--) {
            value *= i;
        }
        return value;
    }
}