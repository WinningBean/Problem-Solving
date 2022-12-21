class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for (String letter : my_string.split("")) {
            sb.append(letter.repeat(n));
        }

        return sb.toString();
    }
}