import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] numStrs = br.readLine().split(" ");
            int num1 = Integer.parseInt(numStrs[0]);
            int num2 = Integer.parseInt(numStrs[1]);
            sb.append(num1 + num2).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}