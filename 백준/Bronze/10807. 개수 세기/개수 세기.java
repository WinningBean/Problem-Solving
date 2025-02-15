import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int num : numArr) {
            if (num == v) cnt++;
        }

        sb.append(cnt);

        System.out.println(sb);
        br.close();
    }
}