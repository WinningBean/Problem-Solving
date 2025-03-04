import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int round = Integer.parseInt(br.readLine()) + 1;
        sb.append(round * 2).append(" ").append(round * 3);

        System.out.println(sb);
        br.close();
    }
}