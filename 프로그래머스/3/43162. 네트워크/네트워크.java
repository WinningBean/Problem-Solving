import java.util.*;

class Solution {
    private Map<Integer, Node> nodeMap;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        nodeMap = new HashMap<>();
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            nodeMap.put(i, node);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    node.connectNum(j);
                }
            }
        }
        
        int answer = 0;
        for (int num : nodeMap.keySet()) {
            if (isNewNetwork(num)) answer++;
        }
        
        return answer;
    }
    
    private boolean isNewNetwork(int num) {
        if (visited[num]) return false;
        visited[num] = true;
        
        Node node = nodeMap.get(num);
        for (int connectNum : node.connectNumSet) {
            isNewNetwork(connectNum);
        }
        
        return true;
    }
}

class Node {
    int num;
    Set<Integer> connectNumSet;
    
    Node(int num) {
        this.num = num;
        connectNumSet = new HashSet<>();
    }
    
    void connectNum(int num) {
        connectNumSet.add(num);
    }
}