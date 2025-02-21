enum AntArmy {
    GENERAL(5), SOLDIER(3), WORKER(1);
    private final int power;
    AntArmy(int power) { this.power = power; }
    public int getPower() { return power; }
}

class Solution {
    public int solution(int hp) {
        int answer = 0;

        for (AntArmy antArmy : AntArmy.values()) {
            int power = antArmy.getPower();
            answer += hp / power;
            hp %= power;
        }
        
        return answer;
    }
}