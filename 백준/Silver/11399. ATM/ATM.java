import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> personTimes = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());

        int result = 0;
        for (int i = N; i > 0; i--) {
            result += i * personTimes.get(N - i);
        }

        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}