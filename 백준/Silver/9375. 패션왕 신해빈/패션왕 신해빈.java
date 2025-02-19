import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Map<String, Integer> itemMap = new HashMap<>();

            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String itemName = br.readLine().split(" ")[1];
                itemMap.put(itemName, itemMap.containsKey(itemName) ? itemMap.get(itemName) + 1 : 1);
            }
            
            int sum = 1;
            for (int item : itemMap.values()) {
                // 아무것도 착용하지 않는 상태를 더하여 경우의 수에 조합
                sum *= item + 1;
            }
            // 알몸 상태 제외
            sum--;

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}