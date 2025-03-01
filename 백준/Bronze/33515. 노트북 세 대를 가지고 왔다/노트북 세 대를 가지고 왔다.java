import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] Tinfo = br.readLine().split(" ");
        int T1 = Integer.parseInt(Tinfo[0]);
        int T2 = Integer.parseInt(Tinfo[1]);

        sb.append(Math.min(T1, T2));

        System.out.println(sb);
        br.close();
    }
}