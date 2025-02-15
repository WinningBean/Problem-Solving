import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        while (N-- > 0) {
            int[] receiptInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum += receiptInfo[0] * receiptInfo[1];
        }

        String result = sum == X ? "Yes" : "No";

        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}