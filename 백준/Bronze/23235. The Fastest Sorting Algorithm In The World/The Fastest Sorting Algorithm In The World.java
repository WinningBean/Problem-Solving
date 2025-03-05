import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        int caseNum = 1;
        while (!(input = br.readLine()).equals("0")) {
            sb.append("Case ")
                .append(caseNum++)
                .append(": Sorting... done!\n");
        }

        System.out.print(sb);
        br.close();
    }
}