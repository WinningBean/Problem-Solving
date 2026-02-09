class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int maxLength = sequence.length;
        int answerLength = maxLength + 1;
        int startIdx = 0, endIdx = 0;
        int sum = 0;
        
        while (startIdx < maxLength && (endIdx < maxLength || sum >= k)) {
            if (sum < k && endIdx < maxLength) {
                sum += sequence[endIdx++];
            }
            
            if (sum >= k) {
                if (sum == k) {
                    int nowLength = endIdx - startIdx;
                    
                    if (answerLength > nowLength) {
                        answer[0] = startIdx;
                        answer[1] = endIdx - 1;

                        answerLength = nowLength;
                        if (answerLength == 1) {
                            break;
                        }
                    }
                }
                sum -= sequence[startIdx++];
            }
        }
        
        return answer;
    }
}