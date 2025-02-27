import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        sb.append(
            """
             @@@   @@@ \s
            @   @ @   @\s
            @    @    @\s
            @         @\s
             @       @ \s
              @     @  \s
               @   @   \s
                @ @    \s
                 @     \s
            """.repeat(N));

        System.out.print(sb);
        br.close();
    }
}