import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = 1;
        while (br.readLine().charAt(0) != '0') {
            sb.append("Case ")
                .append(caseNum++)
                .append(": Sorting... done!\n");
        }

        System.out.print(sb);
        br.close();
    }
}