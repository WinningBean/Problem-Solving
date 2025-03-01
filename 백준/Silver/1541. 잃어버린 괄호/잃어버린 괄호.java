import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String equation = br.readLine();
        List<Integer> numList = new ArrayList<>();

        int numStartIdx = 0;
        int numListIdx = 0;
        for (int i = 0; i < equation.length(); i++) {
            char letter = equation.charAt(i);
            if (numStartIdx == i && letter == '0') {
                // 0으로 시작할 경우 num 시작 인덱스 증가
                numStartIdx++;
            } else if (letter == '+' || letter == '-') {
                // num 시작 인덱스가 현재와 같다면 0, 아니라면 숫자로 변환
                int num = numStartIdx == i ? 0 : Integer.parseInt(equation.substring(numStartIdx, i));

                if (numList.size() == numListIdx + 1) {
                    // 현재 numList가 numListIdx만큼 있다면 이전 숫자 + num -> + 숫자들 모두 합침
                    numList.set(numListIdx, numList.get(numListIdx) + num);
                } else {
                    // 첫번째 인덱스, 혹은 - 다음 숫자는 numList add
                    numList.add(num);
                }

                // - 숫자들 numList에 추가
                if (letter == '-') numListIdx++;

                numStartIdx = i + 1;
            }
        }

        // 마지막 숫자 추가 (0이 아닌 경우)
        if (numStartIdx != equation.length()) {
            int num = Integer.parseInt(equation.substring(numStartIdx, equation.length()));
            if (numList.size() == numListIdx) {
                // 마지막 기호가 - 일 경우
                numList.add(num);
            } else {
                // + 인 경우
                numList.set(numList.size() - 1, numList.get(numListIdx) + num);
            }
        }

        int sum = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            sum -= numList.get(i);
        }
        sb.append(sum);

        System.out.println(sb);
        br.close();
    }
}