import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] info = br.readLine().split(" ");
        int n1 = Integer.parseInt(info[0]);
        int n2 = Integer.parseInt(info[1]);
        int n12 = Integer.parseInt(info[2]);

        sb.append((n1 + 1) * (n2 + 1) / (n12 + 1) - 1);

        System.out.println(sb);
        br.close();
    }
}