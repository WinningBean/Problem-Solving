import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int NS[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NS[0], S = NS[1];
        int cowLength[] = new int[N];

        for (int i = 0; i < N; i++) {
            cowLength[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (cowLength[i] + cowLength[j] <= S) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
        
        br.close();
    }
}