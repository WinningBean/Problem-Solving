import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = null;
        while ((input = br.readLine()) != null) {
            String[] info = input.split(" ");
            int N = Integer.parseInt(info[0]) + 1;
            int S = Integer.parseInt(info[1]);

            sb.append(S / N).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}