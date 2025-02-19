class Solution {
    public int solution(int slice, int n) {
        int needPizza = n / slice;
        if (n % slice > 0) {
            needPizza++;
        }
        return needPizza;
    }
}