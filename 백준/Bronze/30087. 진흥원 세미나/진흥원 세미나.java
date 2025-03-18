import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String seminar = br.readLine();
            String result = "";
            switch (seminar) {
                case "Algorithm":
                    result = "204";
                    break;
                case "DataAnalysis":
                    result = "207";
                    break;
                case "ArtificialIntelligence":
                    result = "302";
                    break;
                case "CyberSecurity":
                    result = "B101";
                    break;
                case "Network":
                    result = "303";
                    break;
                case "Startup":
                    result = "501";
                    break;
                case "TestStrategy":
                    result = "105";
                    break;
                default:
                    break;
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}