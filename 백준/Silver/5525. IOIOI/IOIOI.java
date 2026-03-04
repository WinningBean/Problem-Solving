import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int PnLength = 2 * N + 1;
        int count = 0;

        // Pn이 가능한 만큼만 loop
        for (int i = 0; i <= M - PnLength; i++) {
            char[] nowS = Arrays.copyOfRange(S, i, i + PnLength);
            boolean isPn = true;

            for (int j = 0; j <= PnLength / 2; j += 2) {
                if (nowS[j] != 'I'
                    || nowS[PnLength - j - 1] != 'I'
                    || nowS[j + 1] != 'O'
                    || nowS[PnLength - (j + 1) - 1] != 'O') {
                    isPn = false;
                    break;
                }
            }

            if (isPn) {
                count++;
                i++; // Pn의 경우 바로 다음 문자열은 Pn이 될 수 없음
            }
        }

        System.out.print(count);
        br.close();
    }
}