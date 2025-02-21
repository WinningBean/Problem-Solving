import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        List<Integer> numList = Arrays.stream(s.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        
        StringBuilder sb = new StringBuilder();
        sb.append(Collections.min(numList))
            .append(" ")
            .append(Collections.max(numList));
        
        return sb.toString();
    }
}