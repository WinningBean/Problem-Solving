import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeSet<String> people = new TreeSet<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] personInfo = br.readLine().split(" ");
            if (personInfo[1].equals("enter")) people.add(personInfo[0]);
            else people.remove(personInfo[0]);
        }

        for (String person : people) {
            sb.append(person).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}