import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int L = Integer.parseInt(info[1]);

        int startNum = N / L;
        int length = L;
        boolean isPossibleSequence = false;

        while (startNum >= 0 && length <= 100) {
            int endNum = startNum + length - 1;

            int pairSum = startNum + endNum;
            int sequenceSum = pairSum * (length / 2) + (length % 2 == 1 ? pairSum / 2 : 0);

            while (startNum > 0 && sequenceSum > N) {
                sequenceSum -= length;
                startNum--;
            }

            if (sequenceSum == N) {
                isPossibleSequence = true;
                break;
            }

            length++;
            startNum = N / length;
        }
        
        if (isPossibleSequence) {
            IntStream.range(startNum, startNum + length).forEach(i -> sb.append(i).append(" "));
        } else {
            sb.append(-1);
        }
        
        System.out.print(sb);
        br.close();
    }
}