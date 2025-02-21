class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] maxSumArr = new int[height + 1][height + 1];
        
        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                maxSumArr[i][j] = Math.max(maxSumArr[i + 1][j], maxSumArr[i + 1][j + 1]);
                maxSumArr[i][j] += triangle[i][j];
            }
        }
        
        return maxSumArr[0][0];
    }
}