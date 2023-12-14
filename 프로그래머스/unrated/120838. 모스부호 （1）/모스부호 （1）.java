class Solution {
    private static final String[] MORSE_CODES = {
        ".-","-...","-.-.","-..",".","..-.",
        "--.","....","..",".---","-.-",".-..",
        "--","-.","---",".--.","--.-",".-.",
        "...","-","..-","...-",".--","-..-",
        "-.--","--.."
    };

    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();

        for (String code : letter.split(" ")) {
            System.out.println(code);
            sb.append(getCharacter(code));
        }

        return sb.toString();
    }

    private char getCharacter(String code) {
        for (int i = 0; i < MORSE_CODES.length; i++) {
            if (MORSE_CODES[i].equals(code)) {
                return (char) (i + 'a');
            }
        }

        return '\u0000';
    }
}