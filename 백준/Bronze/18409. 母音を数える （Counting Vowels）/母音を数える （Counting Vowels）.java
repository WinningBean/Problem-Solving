import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        String S = br.readLine();
        int result = 0;
        for (char letter : S.toCharArray()) {
            if (letter == 'a' || letter == 'i' || letter == 'u' || letter == 'e' || letter == 'o') {
                result++;
            }
        }
        sb.append(result);

        System.out.println(sb);
        br.close();
    }
}