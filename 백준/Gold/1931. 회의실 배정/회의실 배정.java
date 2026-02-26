import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
        }

        Arrays.sort(meetings);

        int endHour = 0;
        for (Meeting m : meetings) {
            if (m.start >= endHour) {
                answer++;
                endHour = m.end;
            }
        }

        System.out.print(answer);
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
        if (end < o.end) return -1;
        else if (end > o.end) return 1;
        else if (start < o.start) return -1;
        else if (start > o.start) return 1;
        return 0;
    }
}