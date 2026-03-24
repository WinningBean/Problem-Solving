import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        sb.append(2024 + N * 7 / 12).append(" ").append(N * 7 % 12 + 1);

        System.out.print(sb);
        br.close();
    }
}