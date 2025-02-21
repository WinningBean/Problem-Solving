class Solution {
    public int solution(int[] numbers, int target) {
        return getCaseOfMakeTarget(numbers, target, 0, 0);
    }
    
    int getCaseOfMakeTarget(int[] numbers, int target, int checkIdx, int sum) {
        int result = 0;
        
        if (checkIdx == numbers.length - 1) {
            if (sum + numbers[checkIdx] == target) result++;
            if (sum - numbers[checkIdx] == target) result++;
            return result;
        }
        
        result += getCaseOfMakeTarget(numbers, target, checkIdx + 1, sum + numbers[checkIdx]);
        result += getCaseOfMakeTarget(numbers, target, checkIdx + 1, sum - numbers[checkIdx]);
        
        return result;
    }
}