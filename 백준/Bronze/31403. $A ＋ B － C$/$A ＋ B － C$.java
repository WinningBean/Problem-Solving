import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();
        int C = Integer.parseInt(br.readLine());

        int calcNum = Integer.parseInt(A) + Integer.parseInt(B) - C;
        int calcString = Integer.parseInt(A + B) - C;

        sb.append(calcNum)
            .append("\n")
            .append(calcString);

        System.out.println(sb);
        br.close();
    }
}