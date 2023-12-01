import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();

        // 오늘 날짜
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, format);

        // 약관
        Map<Character, Integer> termsPeriodMap = new HashMap();
        for (String term:terms) {
            String[] arr = term.split(" ");
            termsPeriodMap.put(arr[0].charAt(0), Integer.valueOf(arr[1]));
        }

        // 개인정보
        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            LocalDate startDate = LocalDate.parse(arr[0], format);
            Character termName = arr[1].charAt(0);

            LocalDate endDate = startDate.plusMonths(termsPeriodMap.get(termName));
            if (!todayDate.isBefore(endDate)) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}