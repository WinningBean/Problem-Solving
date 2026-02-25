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
        String[] coordinateStr = br.readLine().split(" ");
        int[] coordinates = new int[N];
        for (int i = 0; i < N; i++) {
            coordinates[i] = Integer.parseInt(coordinateStr[i]);
        }

        int[] orderedCoordinates = coordinates.clone();
        Arrays.sort(orderedCoordinates);

        int order = 0;
        HashMap<Integer, Integer> coordinatesOrderMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!coordinatesOrderMap.containsKey(orderedCoordinates[i])) {
                coordinatesOrderMap.put(orderedCoordinates[i], order++);
            }
        }

        for (int coordinate : coordinates) {
            sb.append(coordinatesOrderMap.get(coordinate)).append(" ");
        }

        System.out.print(sb);
        br.close();
    }
}