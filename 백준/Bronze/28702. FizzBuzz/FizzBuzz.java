import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int resultNum = 0;
        String result = "";

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            char firstLetter = str.charAt(0);
            if (firstLetter != 'F' && firstLetter != 'B') {
                resultNum = Integer.parseInt(str) + 3 - i;
            }
        }

        if (resultNum % 15 == 0) {
            result = "FizzBuzz";
        } else if (resultNum % 3 == 0) {
            result = "Fizz";
        } else if (resultNum % 5 == 0) {
            result = "Buzz";
        } else {
            result = String.valueOf(resultNum);
        }

        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}