import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static final int MAX_DIFFICULTY = 30;
    static final int TRIMMED_MEAN_PERCENT = 30;

    static int[] difficultyOpinions;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        difficultyOpinions = new int[MAX_DIFFICULTY + 1];
        for (int i = 0; i < n; i++) {
            int difficulty = Integer.parseInt(br.readLine());
            difficultyOpinions[difficulty]++;
        }

        int deleteOpinion = Math.round((float) n * TRIMMED_MEAN_PERCENT / 200);
        deleteUpDownOpinion(deleteOpinion);

        int sum = sumOpinion();
        int useOpinion = n - deleteOpinion * 2;
        int result = Math.round((float) sum / useOpinion);

        sb.append(result);

        System.out.println(sb);
        br.close();
    }

    static int sumOpinion() {
        int sum = 0;

        for (int i = 1; i <= MAX_DIFFICULTY; i++) {
            sum += i * difficultyOpinions[i];
        }

        return sum;
    }

    static void deleteUpDownOpinion(int deleteOpinion) {
        if (deleteOpinion == 0) return;

        deleteUpOpinion(deleteOpinion);
        deleteDownOpinion(deleteOpinion);
    }

    static void deleteUpOpinion(int deleteOpinion) {
        int needDeleteOpinion = deleteOpinion;

        for (int i = 1; i <= MAX_DIFFICULTY; i++) {
            if (difficultyOpinions[i] / needDeleteOpinion > 0) {
                difficultyOpinions[i] -= needDeleteOpinion;
                needDeleteOpinion = 0;
                return;
            } else {
                needDeleteOpinion -= difficultyOpinions[i];
                difficultyOpinions[i] = 0;
            }
        }
    }

    static void deleteDownOpinion(int deleteOpinion) {
        int needDeleteOpinion = deleteOpinion;

        for (int i = MAX_DIFFICULTY; i > 0; i--) {
            if (difficultyOpinions[i] / needDeleteOpinion > 0) {
                difficultyOpinions[i] -= needDeleteOpinion;
                needDeleteOpinion = 0;
                return;
            } else {
                needDeleteOpinion -= difficultyOpinions[i];
                difficultyOpinions[i] = 0;
            }
        }
    }
}