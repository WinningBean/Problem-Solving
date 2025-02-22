import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] info = br.readLine().split(" ");
        int T = Integer.parseInt(info[0]);
        int S = Integer.parseInt(info[1]);

        int result = 280;
        if (T > 11 && T < 17 && S == 0) {
            result = 320;
        }
        
        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}