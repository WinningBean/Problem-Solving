class Solution {
    public int[] solution(int[] num_list) {
        int cntEventNum = 0;
        int cntOddNum = 0;

        for (int num :  num_list) {
            if (num % 2 == 0) {
                cntEventNum++;
            } else {
                cntOddNum++;
            }
        }

        int[] answer = {cntEventNum, cntOddNum};
        return answer;
    }
}