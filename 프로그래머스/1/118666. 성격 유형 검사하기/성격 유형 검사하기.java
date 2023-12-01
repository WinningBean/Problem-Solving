class Solution {
    public static final int[] AWARD_SCORES = {3, 2, 1, 0, 1, 2, 3};
    public static final int TYPE_LEN = 8;
    public static final int INDICATOR_TYPE_LEN = 2;

    public String solution(String[] survey, int[] choices) {
        int[] resultScore = new int[TYPE_LEN];

        for (int i = 0; i < survey.length; i++) {
            char[] types = survey[i].toCharArray();
            char choiceType = types[choices[i] < 4 ? 0 : 1];
            resultScore[getTypeScoreIdx(choiceType)] += AWARD_SCORES[choices[i]-1];
        }

        return getResult(resultScore);
    }

    private String getResult(int[] resultScore) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TYPE_LEN; i+=INDICATOR_TYPE_LEN) {
            int resultIdx = resultScore[i] >= resultScore[i+1] ? i : i+1;
            sb.append(getTypeCharacter(resultIdx));
        }

        return sb.toString();
    }

    private int getTypeScoreIdx(char typeChar) {
        switch (typeChar) {
            case 'R': return 0;
            case 'T': return 1;
            case 'C': return 2;
            case 'F': return 3;
            case 'J': return 4;
            case 'M': return 5;
            case 'A': return 6;
            case 'N': return 7;
            default: return -1;
        }
    }

    private char getTypeCharacter(int typeIdx) {
        switch (typeIdx) {
            case 0: return 'R';
            case 1: return 'T';
            case 2: return 'C';
            case 3: return 'F';
            case 4: return 'J';
            case 5: return 'M';
            case 6: return 'A';
            case 7: return 'N';
            default: return ' ';
        }
    }
}