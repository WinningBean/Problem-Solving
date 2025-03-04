import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<String> peopleSet = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] personInfo = br.readLine().split(" ");
            if (personInfo[1].equals("enter")) peopleSet.add(personInfo[0]);
            else peopleSet.remove(personInfo[0]);
        }

        List<String> peopleList = new ArrayList<>(peopleSet);
        peopleList.sort(Collections.reverseOrder());
        for (String person : peopleList) {
            sb.append(person).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}