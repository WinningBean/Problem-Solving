import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        Set<String> strSet = new HashSet<>();

        while (N-- > 0) {
            strSet.add(br.readLine());
        }

        int result = 0;
        while (M-- > 0) {
            if (strSet.contains(br.readLine())) result++;
        }
        
        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}