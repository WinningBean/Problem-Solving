import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final String fanImoticon = ":fan:";

        String id = br.readLine();
        sb.append(fanImoticon.repeat(3))
            .append("\n")
            .append(fanImoticon)
            .append(":").append(id).append(":")
            .append(fanImoticon)
            .append("\n")
            .append(fanImoticon.repeat(3));

        System.out.println(sb);
        br.close();
    }
}