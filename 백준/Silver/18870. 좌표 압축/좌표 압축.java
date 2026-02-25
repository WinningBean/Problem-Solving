import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> coordinates = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // 중복을 없애고 order
        List<Integer> orderedCoordinates = coordinates.stream().distinct().sorted().collect(Collectors.toList());
        HashMap<Integer, Integer> coordinatesOrderMap = new HashMap<>();
        for (int i = 0; i < orderedCoordinates.size(); i++) {
            coordinatesOrderMap.put(orderedCoordinates.get(i), i);
        }

        for (int coordinate : coordinates) {
            sb.append(coordinatesOrderMap.get(coordinate)).append(" ");
        }

        System.out.print(sb);
        br.close();
    }
}