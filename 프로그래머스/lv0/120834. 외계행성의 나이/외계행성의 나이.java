class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String.valueOf(age).chars().forEach(
            i -> sb.append((char)(i + 49))
        );

        return sb.toString();
    }
}