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

        // 1부터 자릿수 높여서 체크
        for (int placeValue = 1; placeValue <= n; placeValue *= 10) {
            int lowNum = n % placeValue; // 아래 자릿수 숫자
            int nowNum = (n / placeValue) % 10; // 현재 자릿수
            int highNum = n / (placeValue * 10); // 위 자릿수 숫자
            
            // d가 0인 경우 앞자리가 0인 경우는 없으니 현재 자릿수 크기만큼 제거
            // -> highNum을 줄여서 미리 세팅
            if (dIsZero) highNum--;

            // 현재 자릿수에 d가 나타날 경우는 위 자릿수 만큼 * 현재 자릿수 크기
            count += highNum * placeValue;
            if (nowNum == d) {
                // 현재 자릿수가 d와 같을 경우 아래 자릿수 만큼 나타남 + 1(0의 경우도 체크)
                count += lowNum + 1;
            } else if (nowNum > d) {
                // 현재 자릿수가 d보다 클 경우 현재 자릿수 크기 만큼 나타남
                count += placeValue;
            }
        }

        System.out.print(count);
        br.close();
    }
}