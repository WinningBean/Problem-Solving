import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] appliedTShirts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] orderBundles = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int tShirtOrderCnt = getTShirtOrderCnt(appliedTShirts, orderBundles[0]);
        int penPOrderCnt = N / orderBundles[1];
        int penOneOrderCnt = N % orderBundles[1];

        sb.append(tShirtOrderCnt)
            .append("\n")
            .append(penPOrderCnt)
            .append(" ")
            .append(penOneOrderCnt);

        System.out.println(sb);
        br.close();
    }

    static int getTShirtOrderCnt(int[] appliedTShirts, int orderBundle) {
        int orderCnt = 0;

        for (int tShirt : appliedTShirts) {
            orderCnt += tShirt / orderBundle;
            if (tShirt % orderBundle > 0) {
                orderCnt++;
            }
        }
        
        return orderCnt;
    }
}