import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int MAX_FRUIT = 2;

        int maxCount = 0;
        int startIdx = 0;
        while (startIdx < N) {
            HashSet<Integer> choiceFruitSet = new HashSet<>();

            int count = 0;
            int checkIdx = startIdx;
            while (checkIdx < N) {
                if (!choiceFruitSet.contains(fruits[checkIdx])) {
                    // 종류가 MAX_FRUIT룰 넘어가면 no count
                    if (choiceFruitSet.size() == MAX_FRUIT) break;
                    choiceFruitSet.add(fruits[checkIdx]);
                    startIdx = checkIdx;
                }
                
                // 마지막 과일 시작 점을 다음 시작점으로
                if (choiceFruitSet.size() == MAX_FRUIT && fruits[checkIdx - 1] != fruits[checkIdx]) {
                    startIdx = checkIdx;
                }
                
                count++;
                checkIdx++;
            }

            if (maxCount < count) {
                maxCount = count;
            }

            if (checkIdx == N) break;
        }

        System.out.print(maxCount);
        br.close();
    }
}