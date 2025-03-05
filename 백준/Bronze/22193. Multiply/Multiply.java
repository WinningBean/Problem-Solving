import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String NM = br.readLine();
        BigInteger numN = new BigInteger(br.readLine());
        BigInteger numM = new BigInteger(br.readLine());

        sb.append(numN.multiply(numM));

        System.out.println(sb);
        br.close();
    }
}