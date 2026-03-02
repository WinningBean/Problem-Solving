import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        boolean dIsZero = d == 0;
        int count = 0;

        for (int placeValue = 1; placeValue <= n; placeValue *= 10) {
            int lowNum = n % placeValue;
            int nowNum = (n / placeValue) % 10;
            int highNum = n / (placeValue * 10);
            
            if (dIsZero) highNum--;

            count += highNum * placeValue;
            if (nowNum == d) {
                count += lowNum + 1;
            } else if (nowNum > d) {
                count += placeValue;
            }
        }

        System.out.print(count);
        br.close();
    }
}