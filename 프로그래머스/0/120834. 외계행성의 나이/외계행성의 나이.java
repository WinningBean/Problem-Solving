class Solution {
    public String solution(int age) {
        char[] ageCharArr = String.valueOf(age).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ageChar : ageCharArr) {
            sb.append((char)(ageChar + 49));
        }

        return sb.toString();
    }
}