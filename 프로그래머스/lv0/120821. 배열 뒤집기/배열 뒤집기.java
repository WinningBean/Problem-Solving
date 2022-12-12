class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] reverse_num_list = new int[len];
        for (int i = 0; i < len; i++) {
            reverse_num_list[i] = num_list[len - i - 1];
        }

        return reverse_num_list;
    }
}