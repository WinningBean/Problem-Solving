import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int X = Integer.parseInt(input[2]);

            sb.append(A * (X - 1) + B).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}