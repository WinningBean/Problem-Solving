import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(num)
                .append(" ")
                .append(num)
                .append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}