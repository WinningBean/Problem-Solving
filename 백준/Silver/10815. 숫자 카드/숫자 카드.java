import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int RANGE = 20000001;
        final int HALF_RANGE = 10000000;

        boolean[] haveCards = new boolean[RANGE];

        String N = br.readLine();
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int card : cards) {
            haveCards[card + HALF_RANGE] = true;
        }
        String M = br.readLine();
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            sb.append(haveCards[num + HALF_RANGE] ? "1 " : "0 "); 
        }

        System.out.println(sb);
        br.close();
    }
}