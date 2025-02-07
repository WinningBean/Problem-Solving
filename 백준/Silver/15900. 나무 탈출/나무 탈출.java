import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] treeInfo = br.readLine().split(" ");
            int idx1 = Integer.parseInt(treeInfo[0]) - 1;
            int idx2 = Integer.parseInt(treeInfo[1]) - 1;

            tree[idx1].add(idx2);
            tree[idx2].add(idx1);
        }

        int cntDepth = getCntTreeDepth(0, 0, 0);
        System.out.println(cntDepth % 2 == 1 ? "Yes" : "No");

        br.close();
    }

    static int getCntTreeDepth(int rootIdx, int nowIdx, int depth) {
        int result = 0;
        for (Integer childIdx : tree[nowIdx]) {
            if (tree[childIdx].size() == 1) {
                result += depth + 1;
            } else if (childIdx != rootIdx) {
                result += getCntTreeDepth(nowIdx, childIdx, depth + 1);
            }
        }
        
        return result;
    }
}