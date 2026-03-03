import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int[] ground = new int[257];
    static int inventory = 0;
    static int time = 0;
    static int minLevel = 256, maxLevel = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        inventory = Integer.parseInt(input[2]);

        for (int i = 0; i < N; i++) {
            String[] blocks = br.readLine().split(" ");
            for (String block : blocks) {
                int level = Integer.parseInt(block);
                ground[level]++;
                minLevel = Math.min(minLevel, level);
                maxLevel = Math.max(maxLevel, level);
            }
        }

        makeGroundFlat(N * M);

        sb.append(time).append(" ").append(maxLevel);

        System.out.print(sb);
        br.close();
    }

    static void makeGroundFlat(int groundSize) {
        while (ground[maxLevel] < groundSize) {
            int work1Time = ground[maxLevel] * 2;
            int work2Time = ground[minLevel];

            // inventory가 work2Time(minLevel 블록 수)보다 같거나 많고
            // work2Time이 work1Time보다 같거나 작으면 work2
            if (inventory >= work2Time && work2Time <= work1Time) {
                work2();
                time += work2Time;
            } else {
                work1();
                time += work1Time;
            }
        }
    }

    static void work1() {
        // maxLevel 블록 수만큼 inventory 채우고 maxLevel 낮추기
        int maxLevelLength = ground[maxLevel];
        inventory += maxLevelLength;
        ground[maxLevel - 1] += maxLevelLength;
        ground[maxLevel] = 0;
        maxLevel--;
    }

    static void work2() {
        // minLevel 블록 수만큼 inventory 바우고 minLevel 높이기
        int minLevelLength = ground[minLevel];
        inventory -= minLevelLength;
        ground[minLevel + 1] += minLevelLength;
        ground[minLevel] = 0;
        minLevel++;
    }
}