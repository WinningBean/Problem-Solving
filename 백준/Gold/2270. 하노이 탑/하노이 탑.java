import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

class Main {
    static final int DIVIDE_NUM = 1000000;

    static ArrayList<Integer>[] disks;
    static int[] checkIdxs;
    static int[] powArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int BAR_CNT = 3;

        int n = Integer.parseInt(br.readLine());
        int[] diskCnts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        disks = new ArrayList[3];
        for (int i = 0; i < BAR_CNT; i++) {
            disks[i] = new ArrayList<>();
            disks[i].addAll(Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        }
        checkIdxs = new int[BAR_CNT];
        makePowArr(n);

        int goalBarIdx = getGoalBarIdx(n);
        int moveCnt = getMoveCntOfHonoi(n, goalBarIdx);

        sb.append(goalBarIdx + 1)
            .append("\n")
            .append(moveCnt);

        System.out.println(sb);
        br.close();
    }

    static int getMoveCntOfHonoi(int diskSize, int to) {
        int moveCnt = 0;

        for (; checkIdxs[to] < disks[to].size(); checkIdxs[to]++) {
            if (disks[to].get(checkIdxs[to]) != diskSize) break;
            diskSize--;
        }

        if (diskSize > 0) {
            int nextBarIdx = getGoalBarIdx(diskSize--);
            checkIdxs[nextBarIdx]++;

            int tempBarIdx = getTempBarIdx(nextBarIdx, to);
            moveCnt += getMoveCntOfHonoi(diskSize, tempBarIdx);
            moveCnt += powArr[diskSize];
            moveCnt %= DIVIDE_NUM;
        }
        
        return moveCnt;
    }

    static int getTempBarIdx(int from, int to) {
        for (int i = 0; i < disks.length; i++) {
            if (i != to && i != from) {
                return i;
            }
        }

        return -1;
    }

    static long getHonoiMoveCnt(int diskSize) {
        return (long) Math.pow(2, diskSize) - 1;
    }

    static int getGoalBarIdx(int baseDisk) {
        for (int i = 0; i < disks.length; i++) {
            if (disks[i].size() > checkIdxs[i] && disks[i].get(checkIdxs[i]) == baseDisk) {
                return i;
            }
        }

        return -1;
    }

    static void makePowArr(int diskSize) {
        powArr = new int[diskSize];
        powArr[0] = 1;
        for (int i = 1; i < diskSize; i++) {
            powArr[i] = powArr[i - 1] * 2 % DIVIDE_NUM;
        }
    }
}