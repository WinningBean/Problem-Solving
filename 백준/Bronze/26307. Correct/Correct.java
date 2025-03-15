import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        sb.append((H - 9) * 60 + M);

        System.out.print(sb);
        br.close();
    }
}