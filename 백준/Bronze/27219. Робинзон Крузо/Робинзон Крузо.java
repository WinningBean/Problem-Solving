import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        sb.append("V".repeat(N / 5)).append("I".repeat(N % 5));

        System.out.print(sb);
        br.close();
    }
}