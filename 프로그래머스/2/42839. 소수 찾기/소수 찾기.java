import java.util.*;

class Solution {
    Set<Integer> primeSet;
    boolean[] visited;
    
    public int solution(String numbers) {
        primeSet = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        makePrimeSet(numbers, 0);
        
        return primeSet.size();
    }
    
    void makePrimeSet(String numbers, int checkNum) {
        String numStr = Integer.toString(checkNum);
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            int nowNum = Integer.parseInt(numStr + numbers.charAt(i));
            if (!primeSet.contains(nowNum) && isPrime(nowNum)) {
                primeSet.add(nowNum);
            } 
            makePrimeSet(numbers, nowNum);
            visited[i] = false;
        }
    }
    
    boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}