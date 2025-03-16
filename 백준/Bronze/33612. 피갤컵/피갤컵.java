import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int year = 2024;
        int month = 8;
        for (int i = 1; i < N; i++) {
            month += 7;
            if (month > 12) {
                year++;
                month -= 12;
            }
        }
        sb.append(year).append(" ").append(month);

        System.out.print(sb);
        br.close();
    }
}