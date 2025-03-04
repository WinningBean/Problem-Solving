import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger all = new BigInteger(br.readLine());
        BigInteger klaudia = new BigInteger(br.readLine());

        BigInteger divide = all.subtract(klaudia).divide(BigInteger.TWO);
        sb.append(divide.add(klaudia))
            .append("\n")
            .append(divide);

        System.out.println(sb);
        br.close();
    }
}