import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int[][] combination = new int[31][31];

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
        if (n == r || r == 0) {
            combination[n][r] = 1;
        }

        if (combination[n][r] == 0) {
            combination[n][r] = getCombination(n - 1, r - 1) + getCombination(n - 1, r);
        }

        return combination[n][r];
    }
}