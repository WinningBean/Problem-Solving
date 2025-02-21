import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefixSumArr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSumArr[i + 1] = prefixSumArr[i] + numArr[i];
        }

        while (M-- > 0) {
            String[] problemInfo = br.readLine().split(" ");
            int startIdx = Integer.parseInt(problemInfo[0]);
            int endIdx = Integer.parseInt(problemInfo[1]);
            sb.append(prefixSumArr[endIdx] - prefixSumArr[startIdx - 1]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}