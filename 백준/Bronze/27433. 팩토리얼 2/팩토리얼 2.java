import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        sb.append(factorial[N]);

        System.out.print(sb);
        br.close();
    }
}