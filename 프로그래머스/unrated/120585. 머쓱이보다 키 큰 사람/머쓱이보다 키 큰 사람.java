class Solution {
    public int solution(int[] array, int height) {
        int cnt = 0;
        for (int i : array) {
            if (i > height) cnt++;
        }
        return cnt;
    }
}