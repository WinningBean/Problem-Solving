import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char input = br.readLine().charAt(0);

        String result = "Naver Whale";
        if (input == 'N' || input == 'n') {
            result = "Naver D2";
        }

        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}