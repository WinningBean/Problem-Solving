import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ISBN = br.readLine().toCharArray();

        int sum = 0;
        int damagedMultiply = 0;
        for (int i = 0; i < 13; i++) {
            int multiply = i % 2 == 0 ? 1 : 3;

            if (ISBN[i] == '*') {
                damagedMultiply = multiply;
            } else {
                sum += multiply * (ISBN[i] - '0');
            }
        }

        int rest = 10 - sum % 10;
        int answer = rest % 10;
        if (answer > 0 && damagedMultiply == 3) {
            for (int i = 1; i < 10; i++) {
                if (rest == i * damagedMultiply % 10) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.print(answer);
        br.close();
    }
}