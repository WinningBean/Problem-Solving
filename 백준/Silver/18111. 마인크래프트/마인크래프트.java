import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static final int MAX_GROUND_LEVEL = 256;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[2]);

        int[] ground = new int[MAX_GROUND_LEVEL + 1];
        int minLevel = MAX_GROUND_LEVEL, maxLevel = 0;

        for (int i = 0; i < N; i++) {
            String[] blocks = br.readLine().split(" ");
            for (String block : blocks) {
                int level = Integer.parseInt(block);
                ground[level]++;
                minLevel = Math.min(minLevel, level);
                maxLevel = Math.max(maxLevel, level);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int flatLevel = 0;

        // 만들어 질 수 있는 모든 레벨
        for (int nowLevel = minLevel; nowLevel <= maxLevel; nowLevel++) {
            int nowTime = 0;
            int nowInventory = B;

            // 가장 낮은 레벨부터 현재 레벨 전까지
            for (int lowLevel = minLevel; lowLevel < nowLevel; lowLevel++) {
                int addBlocks = (nowLevel - lowLevel) * ground[lowLevel];
                nowTime += addBlocks;
                nowInventory -= addBlocks;
            }

            // 다음 레벨부터 가장 높은 레벨까지
            for (int highLevel = nowLevel + 1; highLevel <=maxLevel; highLevel++) {
                int removeBlocks = (highLevel - nowLevel) * ground[highLevel];
                nowTime += removeBlocks * 2;
                nowInventory += removeBlocks;
            }

            // 현재 레벨로 만들기 위한 블록이 충분하지 않다면 다음 레벨 체크
            if (nowInventory < 0) continue;
            
            if (nowTime <= minTime) {
                minTime = nowTime;
                flatLevel = nowLevel;
            }
        }

        sb.append(minTime).append(" ").append(flatLevel);

        System.out.print(sb);
        br.close();
    }
}