import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static final int BOARD_SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] board = new int[BOARD_SIZE + 1];
        while (N-- > 0) {
            String[] ladder = br.readLine().split(" ");
            board[Integer.parseInt(ladder[0])] = Integer.parseInt(ladder[1]);
        }
        while (M-- > 0) {
            String[] snake = br.readLine().split(" ");
            board[Integer.parseInt(snake[0])] = Integer.parseInt(snake[1]);
        }

        int minCnt = getMinDiceCnt(board, 1, 100);

        System.out.print(minCnt);
        br.close();
    }

    static int getMinDiceCnt(int[] board, int from, int to) {
        Queue<Integer> spaceQueue = new LinkedList<Integer>();
        int[] diceCnts = new int[BOARD_SIZE + 1];
        spaceQueue.add(from);

        while (!spaceQueue.isEmpty()) {
            int space = spaceQueue.poll();

            for (int i = 1; i <= 6; i++) {
                int nextSpace = space + i;
                if (diceCnts[nextSpace] > 0) continue;
                diceCnts[nextSpace] = diceCnts[space] + 1;
                if (nextSpace == to) return diceCnts[to];

                boolean canGo = true;
                while (board[nextSpace] > 0) {
                    // 이어진 곳을 이미 방문 했다면 갈 필요 없음 
                    if (diceCnts[board[nextSpace]] > 0) {
                        canGo = false;
                        break;
                    }
                    nextSpace = board[nextSpace];
                    diceCnts[nextSpace] = diceCnts[space] + 1;
                }

                if (canGo) spaceQueue.add(nextSpace);
            }
        }

        return -1;
    }
}