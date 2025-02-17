import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] problemInfo = br.readLine().split(" ");
        int N = Integer.parseInt(problemInfo[0]);
        int M = Integer.parseInt(problemInfo[1]);

        Map<String, String> sitePwMap = new HashMap<>();

        while (N-- > 0) {
            String[] sitePwInfo = br.readLine().split(" ");
            sitePwMap.put(sitePwInfo[0], sitePwInfo[1]);
        }

        while (M-- > 0) {
            String site = br.readLine();
            sb.append(sitePwMap.get(site)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}