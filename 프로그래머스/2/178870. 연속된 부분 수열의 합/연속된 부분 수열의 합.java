class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int maxLength = sequence.length;
        int answerLength = maxLength + 1;
        int startIdx = 0, endIdx = 0;
        int checkLength = 0;
        int sum = 0;
        
        while (startIdx < maxLength) {
            while (sum < k && endIdx < maxLength) {
                sum += sequence[endIdx++];
                checkLength++;
            }
            
            if (sum == k && answerLength > checkLength) {
                answer[0] = startIdx;
                answer[1] = endIdx - 1;
                answerLength = checkLength;
                
                if (checkLength == 1) {
                    break;
                }
            }
            
            sum -= sequence[startIdx++];
            checkLength--;
        }
        
        return answer;
    }
}