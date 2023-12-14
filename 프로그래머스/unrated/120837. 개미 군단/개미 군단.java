class Solution {
    private static final int GENERAL_POWER = 5;
    private static final int SOLDIER_POWER = 3;
    private static final int WORKER_POWER = 1;

    public int solution(int hp) {
        int answer = 0;

        answer += hp / GENERAL_POWER;
        hp %= GENERAL_POWER;

        answer += hp / SOLDIER_POWER;
        hp %= SOLDIER_POWER;

        answer += hp / WORKER_POWER;
        hp %= WORKER_POWER;
        
        return answer;
    }
}