import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] problemInfo = br.readLine().split(" ");
        int N = Integer.parseInt(problemInfo[0]);
        int M = Integer.parseInt(problemInfo[1]);

        String[] pokemonArr = new String[N + 1];
        HashMap<String, Integer> pokemonMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            pokemonArr[i] = br.readLine();
            pokemonMap.put(pokemonArr[i], i);
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            String answer = "";

            if (pokemonMap.containsKey(problem)) {
                answer = pokemonMap.get(problem).toString();
            } else {
                int pokemonNum = Integer.parseInt(problem);
                answer = pokemonArr[pokemonNum];
            }

            sb.append(answer)
                .append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}