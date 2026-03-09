import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        List<Integer> heightList = new ArrayList<>();
        HashSet<Integer> heightSet = new HashSet<>();
        heightList.add(height);
        heightSet.add(height);

        for (int i = 1; i <= N; i++) {
            if (height % 2 == 0) height = (height / 2) ^ 6;
            else height = (2 * height) ^ 6;

            // 높이 loop 전에 N초에 도달한 경우
            if (i == N) break;

            if (heightSet.contains(height)) {
                // 높이 loop에 도달
                List<Integer> heightLoopList = getHeightLoopList(heightSet, heightList, height, i);
                height = getSecondsHeight(heightLoopList, i, N);
                break;
            }

            // 높이 loop에 도달하지 않았다면 그 전 높이 저장
            heightList.add(height);
            heightSet.add(height);
        }

        System.out.print(height);
        br.close();
    }
    
    static private int getSecondsHeight(List<Integer> heightLoopList, int fromSeconds, int toSeconds) {
        int leftSeconds = toSeconds - fromSeconds;
        // 남은 시간에서 높이 loop에 해당하는 높이 반환
        int loopSeconds = leftSeconds % heightLoopList.size();
        return heightLoopList.get(loopSeconds);
    }


    static private List<Integer> getHeightLoopList(HashSet<Integer> heightSet, List<Integer> heightList, int loopStartHeight, int newLoopSeconds) {
        int loopStartSeconds = 0;
        for (int i = 0; i < newLoopSeconds; i++) {
            // 높이 loop의 시작 초
            if (heightList.get(i) == loopStartHeight) {
                loopStartSeconds = i;
                break;
            }
        }

        // 높이 loop list
        return heightList.subList(loopStartSeconds, newLoopSeconds);
    }
}