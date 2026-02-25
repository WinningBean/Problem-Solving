import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] coordinates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 중복을 없애고 order
        int[] orderedCoordinates = Arrays.stream(coordinates).distinct().sorted().toArray();
        HashMap<Integer, Integer> coordinatesOrderMap = new HashMap<>();
        for (int i = 0; i < orderedCoordinates.length; i++) {
            coordinatesOrderMap.put(orderedCoordinates[i], i);
        }

        for (int coordinate : coordinates) {
            sb.append(coordinatesOrderMap.get(coordinate)).append(" ");
        }

        System.out.print(sb);
        br.close();
    }
}