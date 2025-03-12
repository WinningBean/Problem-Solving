import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int V = Integer.parseInt(br.readLine());
        sb.append(T * V);

        System.out.print(sb);
        br.close();
    }
}