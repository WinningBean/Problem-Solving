import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefixSumArr = new int[NM[0] + 1];
        for (int i = 1; i <= NM[0]; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + numArr[i - 1];
        }

        while (NM[1]-- > 0) {
            int[] problemInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(prefixSumArr[problemInfo[1]] - prefixSumArr[problemInfo[0] - 1]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}