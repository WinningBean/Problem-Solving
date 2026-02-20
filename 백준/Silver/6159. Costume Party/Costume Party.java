import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        String NS[] = br.readLine().split(" ");
        int N = Integer.parseInt(NS[0]);
        int S = Integer.parseInt(NS[1]);
        int cows[] = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows);

        int startIdx = 0;
        int endIdx = N - 1;

        while (startIdx < endIdx) {
            // 시작점과 끝점이 S보다 클 경우 끝점 위치를 옮긴다
            while (cows[startIdx] + cows[endIdx] > S) {
                endIdx--;

                if (endIdx == startIdx) {
                    break;
                }
            }

            // 시작점과 끝점이 S와 같거나 작을 경우 경우의 수 count, 시작점 위치를 옮긴다
            answer += (endIdx - startIdx);
            startIdx++;
        }

        System.out.print(answer);
        
        br.close();
    }
}