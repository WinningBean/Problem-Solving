import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MAX_ABS_NUM = 1000000;

        int N = Integer.parseInt(br.readLine());
        int[] numStates = new int[MAX_ABS_NUM * 2 + 1];

        for (int i = 0; i < N; i++) {
            numStates[Integer.parseInt(br.readLine()) + MAX_ABS_NUM]++;
        }

        for (int i = 0; i < numStates.length; i++) {
            for (int j = 0; j < numStates[i]; j++) {
                sb.append(i - MAX_ABS_NUM).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}