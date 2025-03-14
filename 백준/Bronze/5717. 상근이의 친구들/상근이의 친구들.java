import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] friends = input.split(" ");
            int M = Integer.parseInt(friends[0]);
            int F = Integer.parseInt(friends[1]);
            sb.append(M + F).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}