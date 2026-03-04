import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        boolean[] canP = getCanP(S, M);
        int count = getCanPnCount(N, M, canP);

        System.out.print(count);
        br.close();
    }

    /// Pn을 만들 수 있는 경우의 수 반환
    static int getCanPnCount(int N, int M, boolean[] canP) {
        int PnLength = 2 * N + 1;
        int count = 0;
        int start = 0, end = 0;

        // Pn이 만들어 질 수 있는 길이만큼 loop
        while (start <= M - PnLength) {
            if (!canP[start]) {
                start++;
                end++;
                continue;
            }
            boolean isPn = true;

            // 확인된 부분이 PnLength보다 작을 때 loop
            while (end - start + 3 < PnLength) {
                if (canP[end + 2]) {
                    // 최소 단위는 3글자 -> end + 2가 P문자열인지 확인
                    end += 2;
                } else {
                    isPn = false;
                    break;
                }
            }

            if (isPn) {
                count++;
                start += 2; // P문자열이면 바로 다음은 P문자열이 될 수 없음
            } else {
                start = ++end;
            }
        }

        return count;
    }

    /// P의 최소 단위 'IOI' 가능 여부 반환
    static boolean[] getCanP(char[] S, int M) {
        boolean[] canP = new boolean[M];

        for (int i = 0; i < M - 2; i++) {
            if (S[i] == 'I' && S[i + 1] == 'O' && S[i + 2] == 'I') {
                canP[i] = true;
                i++; // P문자열이면 바로 다음은 P문자열이 될 수 없음
            }
        }

        return canP;
    }
}