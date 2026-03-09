import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            meetingList.add(new Meeting(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
        }

        Collections.sort(meetingList);

        int count = 0;
        int endHour = 0;
        for (Meeting m : meetingList) {
            if (m.start >= endHour) {
                count++;
                endHour = m.end;
            }
        }

        System.out.print(count);
        br.close();
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    Meeting (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (end == o.end) {
            return Integer.compare(start, o.start);
        }
        return Integer.compare(end, o.end);
    }
}