import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntUnaryOperator;

class Main{
    static final int MIN_NUM = 0;
    static final int MAX_NUM = 9999;
    static IntUnaryOperator[] calcDSLR = {
        Main::calcD,
        Main::calcS,
        Main::calcL,
        Main::calcR
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
        Queue<Integer> calcQueue = new LinkedList<>();
        StringBuilder[] calcRecords = new StringBuilder[10000];

        calcQueue.add(from);
        calcRecords[from] = new StringBuilder();

        while (calcQueue.peek() != to) {
            int num = calcQueue.poll();

            for (int i = 0; i < 4; i++) {
                int calcNum = calcDSLR[i].applyAsInt(num);
                if (calcRecords[calcNum] == null) {
                    calcRecords[calcNum] = new StringBuilder();
                    calcRecords[calcNum].append(calcRecords[num]).append(calcDSLRnames[i]);
                    calcQueue.add(calcNum);
                }
            }
        }

        return calcRecords[to];
    }

    static int calcD(int num) {
        num *= 2;
        if (num > MAX_NUM) {
            num %= 10000;
        }
        return num;
    }
    
    static int calcS(int num) {
        if (num == MIN_NUM) return MAX_NUM;
        return --num;
    }

    static int calcL(int num) {
        return (num % 1000) * 10 + (num / 1000);
    }

    static int calcR(int num) {
        return (num % 10) * 1000 + (num / 10);
    }
}