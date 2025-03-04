import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = Integer.parseInt(br.readLine())) > 0) {
            int result = (n + 1) * (n / 2);
            if (n % 2 == 1) result += (n + 1) / 2;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}