import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        final int MAX_FRUIT = 2;

        int count = 0;
        int start = 0;
        while (start < N) {
            boolean[] usedFruits = new boolean[10];
            int end = start;
            int nextStart = end;
            int used = 0;

            while (end < N) {
                int nowFruit = fruits[end];
                if (!usedFruits[nowFruit]) {
                    if (used == MAX_FRUIT) break;
                    used++;
                }
                if (fruits[nextStart] != nowFruit) {
                    nextStart = end;
                }
                usedFruits[nowFruit] = true;
                end++;
            }
            
            count = Math.max(count, end - start);

            if (end == N) break;
            start = nextStart;
        }

        System.out.print(count);
        br.close();
    }
}