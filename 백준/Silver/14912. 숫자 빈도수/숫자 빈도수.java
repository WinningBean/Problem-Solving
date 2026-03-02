import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        char[] nArr = input[0].toCharArray();
        int d = Integer.parseInt(input[1]);

        boolean isZero = d == 0;
        int digit = nArr.length;
        int count = 0;

        // 1의 자릿수 이전까지 계산
        for (int i = 0; i < digit - 1; i++) {
            int num = nArr[i] - '0';
            int nowDisit = digit - i;

            // 현재 자릿수에서 한 숫자가 나오는 빈도수
            int frequency = (nowDisit - 1) * (int) Math.pow(10, nowDisit - 2);
            // 현재 자릿수의 숫자만큼 빈도수가 나온다.
            count += num * frequency;
            // 앞자리가 0인 경우는 없으므로 d가 0인 경우 다음 자릿수 * 10만큼 제외
            if (isZero) {
                count -= (int) Math.pow(10, nowDisit - 2);
            }
        
            if (num > d && (!isZero || (isZero && i > 0))) {
                // 현재 자릿수가 d보다 크면 해당 자릿수 크기만큼 count
                // 앞자리가 0인 경우는 없으므로 d가 0인 경우 맨 앞 자릿수는 제외
                count += (int) Math.pow(10, nowDisit - 1);
            } else if (num == d) {
                // 현재 자릿수가 d와 같다면 그 아래 수만큼 count + 1(0 count)
                count += Integer.parseInt(new String(Arrays.copyOfRange(nArr, i + 1, digit))) + 1;
            }
        }

        // 1의 자릿수 따로 계산
        // 1의 자릿수가 d보다 같거나 크면 한 번 더 count
        int digitOneNum = nArr[digit - 1] - '0';
        if (digitOneNum >= d) count++;

        System.out.print(count);
        br.close();
    }
}