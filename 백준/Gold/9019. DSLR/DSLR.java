import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.IntUnaryOperator;

class Main {
    static IntUnaryOperator[] calcDSLR = {
        x -> (x * 2) % 10000,
        x -> (x == 0) ? 9999 : x - 1,
        x -> (x % 1000) * 10 + (x / 1000),
        x -> (x % 10) * 1000 + (x / 10)
    };
    static char[] calcDSLRnames = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            sb.append(getMinCalc(A, B)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static StringBuilder getMinCalc(int from, int to) {
        Queue<Integer> calcQueue = new ArrayDeque<>();
        char[] calcRecords = new char[10000];
        int[] prevNums = new int[10000];

        calcQueue.add(from);
        calcRecords[from] = '\n';

        while (calcQueue.peek() != to) {
            int num = calcQueue.poll();

            for (int i = 0; i < 4; i++) {
                int calcNum = calcDSLR[i].applyAsInt(num);
                if (calcRecords[calcNum] != '\u0000') continue;

                prevNums[calcNum] = num;
                calcRecords[calcNum] = calcDSLRnames[i];
                calcQueue.add(calcNum);
            }
        }

        return getReverseFromTo(to, from, prevNums, calcRecords);
    }

    static StringBuilder getReverseFromTo(int from, int to, int[] nextIdxs, char[] chars) {
        char[] buffer = new char[10000];
        int idx = 10000;

        while (from != to) {
            buffer[--idx] = chars[from];
            from = nextIdxs[from];
        }

        return new StringBuilder().append(buffer, idx, 10000 - idx);
    }
}