import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] LCS = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
                }
            }
        }

        StringBuilder LCSsb = new StringBuilder();
        int checkLen = LCS[str1.length()][str2.length()];
        for (int i = str1.length(); i > 0; i--) {
            for (int j = str2.length(); j > 0; j--) {
                if (LCS[i][j] == checkLen
                    && LCS[i][j] > LCS[i - 1][j - 1]
                    && LCS[i][j] > LCS[i - 1][j]
                    && LCS[i][j] > LCS[i][j - 1]) {
                    LCSsb.insert(0, str1.charAt(i - 1));
                    checkLen--;
                    break;
                } 
            }
        }

        sb.append(LCSsb);

        System.out.println(sb);
        br.close();
    }
}