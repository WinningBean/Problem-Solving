import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main{
    static HashMap<Integer, Integer> meetingMinHourMap;
    static HashMap<Integer, Integer> maxMeeingMap;
    static HashMap<Integer, Integer> quickMeetingMap;
    static int maxStartHour;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        maxStartHour = 0;

        int N = Integer.parseInt(br.readLine());
        meetingMinHourMap = new HashMap<>();
        maxMeeingMap = new HashMap<>();
        quickMeetingMap = new HashMap<>();
        while (N-- > 0) {
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]), end = Integer.parseInt(info[1]);
            if (maxStartHour < start) maxStartHour = start;

            if (start == end) {
                quickMeetingMap.put(start, quickMeetingMap.containsKey(start) ? quickMeetingMap.get(start) + 1 : 1);
            } else if (!meetingMinHourMap.containsKey(start)
                || (meetingMinHourMap.containsKey(start) && meetingMinHourMap.get(start) > end)) {
                meetingMinHourMap.put(start, end);
            }
        }

        int maxMetting = 0;
        for (int i = 0; i <= maxStartHour; i++) {
            int metting = getMaxMettings(i);
            if (maxMetting < metting) maxMetting = metting;
        }
        answer += maxMetting;

        System.out.print(answer);
        br.close();
    }

    static int getMaxMettings(int checkHour) {
        if (checkHour > maxStartHour) return 0;
        if (maxMeeingMap.containsKey(checkHour)) return maxMeeingMap.get(checkHour);

        // 다음 시간부터 최대 회의 체크
        maxMeeingMap.put(checkHour, getMaxMettings(checkHour + 1));

        // 예약된 회의가 있다면 회의 끝나는 시간부터 구하고 회의 하나 증가
        if (meetingMinHourMap.containsKey(checkHour)) {
            // 예약된 회의 진행 & 다음 시간부터 진행 중 최대값 선택
            int reservationMaxMeeting = getMaxMettings(meetingMinHourMap.get(checkHour)) + 1;
            maxMeeingMap.put(checkHour, Math.max(maxMeeingMap.get(checkHour), reservationMaxMeeting));
        }

        // 바로 끝나는 회의가 있다면 증가
        if (quickMeetingMap.containsKey(checkHour)) {
            maxMeeingMap.put(checkHour, maxMeeingMap.get(checkHour) + quickMeetingMap.get(checkHour));
        }

        return maxMeeingMap.get(checkHour);
    }
}