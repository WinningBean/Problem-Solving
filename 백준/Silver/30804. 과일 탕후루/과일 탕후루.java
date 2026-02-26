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
        int[] fruitSequenceCounts = getSequenceCounts(fruits);

        final int MAX_FRUIT = 2;
        int maxCount = 0;
        int checkIdx = 0;

        while (checkIdx < N) {
            HashSet<Integer> fruitSet = new HashSet<>();
            int count = 0;

            int nowIdx = checkIdx;
            while (nowIdx < N) {
                if (!fruitSet.contains(fruits[nowIdx])) {
                    if (fruitSet.size() == MAX_FRUIT) break;
                    fruitSet.add(fruits[nowIdx]);
                }

                checkIdx = nowIdx;
                count += fruitSequenceCounts[nowIdx];
                nowIdx += fruitSequenceCounts[nowIdx];
            }

            if (maxCount < count) {
                maxCount = count;
            }
            
            if (nowIdx == N) break;
        }

        System.out.print(maxCount);
        br.close();
    }

    static int[] getSequenceCounts(int[] arr) {
        int length = arr.length;
        int[] sequenceCounts = new int[length];

        int checkIdx = 0;
        while (checkIdx < length) {
            int startIdx = checkIdx;
            int num = arr[checkIdx];
            while (checkIdx < length && arr[checkIdx] == num) {
                checkIdx++;
                sequenceCounts[startIdx]++;
            }
        }

        return sequenceCounts;
    }
}