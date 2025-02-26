import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            String result = "yes";
            if (str.length() < 6 || str.length() > 9 ) {
                result = "no";
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}