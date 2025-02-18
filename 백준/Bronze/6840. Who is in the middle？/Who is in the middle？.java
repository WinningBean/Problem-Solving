import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());

        int result = num1;

        if ((num1 < num2 && num2 < num3) || (num3 < num2 && num2 < num1)) {
            result = num2;
        } else if ((num1 < num3 && num3 < num2) || (num2 < num3 && num3 < num1)) {
            result = num3;
        }

        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}