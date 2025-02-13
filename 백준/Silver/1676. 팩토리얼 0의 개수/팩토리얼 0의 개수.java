import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 5; i <= N; i+=5) {
            int calc = i;
            while (calc % 5 == 0) {
                calc /= 5;
                result++;
            }
        }

        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}