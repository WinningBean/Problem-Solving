import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] infos = br.readLine().split(" ");
            int x1 = Integer.parseInt(infos[0]);
            int y1 = Integer.parseInt(infos[1]);
            int r1 = Integer.parseInt(infos[2]);
            int x2 = Integer.parseInt(infos[3]);
            int y2 = Integer.parseInt(infos[4]);
            int r2 = Integer.parseInt(infos[5]);

            int result = 0;
            if (x1 == x2 && y1 == y2) {
                result = r1 == r2 ? -1 : 0;
            } else {
                double turretDistance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                int enemyDistance = r1 + r2;
                int enemyMinusDistance = Math.abs(r1 - r2);

                if (enemyDistance == turretDistance || enemyMinusDistance == turretDistance) {
                    result = 1;
                } else if (enemyDistance > turretDistance) {
                    result = enemyMinusDistance > turretDistance ? 0 : 2;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}