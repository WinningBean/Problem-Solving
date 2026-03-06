import java.util.*;
import java.util.function.*;

class Solution {
    final int MIN_NUM = 1;
    final int MAX_NUM = 32000;
    
    Set<Integer>[] useNumSets;
    boolean[] visited;
    IntBinaryOperator[] calc = {
        (a, b) -> a + b,
        (a, b) -> a - b,
        (a, b) -> a / b,
        (a, b) -> a * b
    };
    
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        // useNumSets를 초기화하고 먼저 그 중에 있는지 체크
        initUseNumSets(N);
        int answer = getMinUseNumCount(number);
        if (answer > 0) return answer;
        
        // 초기화 중에 없다면 2개부터 8개까지 설정 후 체크 loop
        for (int i = 2; i <= 8; i++) {
            setUseNumSets(i);
            if (isUseCountMakeTargetNum(number, i)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private void setUseNumSets(int useCount) {
        // 괄호 연산 포함하기 위해 가능한 모든 경우의 수 loop
        for (int i = 1; i < useCount; i++) {
            setUseNumSet(useCount, useNumSets[i], useNumSets[useCount - i]);
        }
    }
    
    private void setUseNumSet(int useCount,Set<Integer> useNumSetA, Set<Integer> useNumSetB) {
        for (int a : useNumSetA) {
            for (int b : useNumSetB) {
                for (int i = 0; i < 4; i++) {
                    int calcNum = calc[i].applyAsInt(a, b);
                    if (calcNum < MIN_NUM
                        || calcNum > MAX_NUM
                        || visited[calcNum]) continue;

                    visited[calcNum] = true;
                    useNumSets[useCount].add(calcNum);
                }
            }
        }
    }
    
    private int getMinUseNumCount(int targetNum) {
        for (int i = 1; i <= 8; i++) {
            if (isUseCountMakeTargetNum(targetNum, i)) {
                return i;
            }
        }
        
        return -1;   
    }
    
    private boolean isUseCountMakeTargetNum(int targetNum, int useCount) {
        
        for (int num : useNumSets[useCount]) {
            if (num == targetNum) {
                return true;
            }
        }
        return false;
    }
    
    /// useNum을 붙여서 만든 숫자들 먼저 초기화
    private void initUseNumSets(int useNum) {
        useNumSets = new HashSet[9];
        visited = new boolean[MAX_NUM + 1];
        
        for (int i = 1; i <= 8; i++) {
            useNumSets[i] = new HashSet<>();
            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + useNum;
            }
            useNumSets[i].add(num);
        }
    }
}