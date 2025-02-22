import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> numStrList = new ArrayList<>();
        for (int num : numbers) {
            numStrList.add(Integer.toString(num));
        }
        numStrList.sort((a, b) -> (b + a).compareTo(a + b));
        
        if (numStrList.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrList) {
            sb.append(numStr);
        }
        
        return sb.toString();
    }
}