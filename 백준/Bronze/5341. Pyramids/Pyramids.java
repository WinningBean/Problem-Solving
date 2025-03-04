import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = Integer.parseInt(br.readLine())) > 0) {
            sb.append(n * (n + 1) / 2).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}