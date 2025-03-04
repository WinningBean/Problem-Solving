import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int RANGE = 20000001;

        boolean[] haveCards = new boolean[RANGE];

        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int card : cards) {
            if (card < 0) card += RANGE;
            haveCards[card] = true;
        }

        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            if (num < 0) num += RANGE;
            sb.append(haveCards[num] ? "1 " : "0 "); 
        }

        System.out.println(sb);
        br.close();
    }
}