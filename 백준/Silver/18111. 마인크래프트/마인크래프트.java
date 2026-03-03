import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[2]);

        int[] ground = new int[257];
        int minLevel = 256, maxLevel = 0;

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

        // 만들어 질 수 있는 모든 레벨 체크
        for (int nowLevel = minLevel; nowLevel <= maxLevel; nowLevel++) {
            // 가장 낮은 레벨부터 현재 레벨 전까지 더해야 할 블록 체크
            int addBlocks = 0;
            for (int lowLevel = minLevel; lowLevel < nowLevel; lowLevel++) {
                addBlocks += (nowLevel - lowLevel) * ground[lowLevel];
            }

            // 다음 레벨부터 가장 높은 레벨까지 제거해야 할 블록 체크
            int removeBlocks = 0;
            for (int highLevel = nowLevel + 1; highLevel <= maxLevel; highLevel++) {
                removeBlocks += (highLevel - nowLevel) * ground[highLevel];
            }

            // 현재 레벨로 만들기 위한 블록이 충분하지 않다면 다음 레벨 체크
            if (removeBlocks + B < addBlocks) continue;

            int nowTime = addBlocks + removeBlocks * 2;
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