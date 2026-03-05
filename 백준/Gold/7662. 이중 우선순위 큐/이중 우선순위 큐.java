import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            DualPriorityQueue queue = new DualPriorityQueue(k);

            while (k-- > 0) {
                String input = br.readLine();
                char calc = input.charAt(0);
                int n = Integer.parseInt(input.substring(2));

                if (calc == 'I') {
                    // 삽입 연산
                    queue.addNum(n);
                } else {
                    // 삭제 연산
                    if (n == 1) {
                        // 최댓값 삭제
                        queue.deleteMaxNum();
                    } else {
                        // 최솟값 삭제
                        queue.deleteMinNum();
                    }
                }
            }

            if (queue.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(queue.getMaxNum()).append(" ").append(queue.getMinNum()).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}

class DualPriorityQueue {
    Map<Integer, Integer> countMap;
    MaxHeap maxHeap;
    MinHeap minHeap;

    DualPriorityQueue(int size) {
        countMap = new HashMap<>();
        maxHeap = new MaxHeap(size);
        minHeap = new MinHeap(size);
    }

    void addNum(int num) {
        // 이미 있는 숫자
        if (countMap.containsKey(num)) {
            countMap.put(num, countMap.get(num) + 1);
            return;
        }

        countMap.put(num, 1);
        maxHeap.insert(num);
        minHeap.insert(num);
    }

    void deleteMaxNum() {
        if (isEmpty()) return;

        int maxNum = getMaxNum();
        int count = countMap.get(maxNum);
        if (--count > 0) {
            countMap.put(maxNum, count);
            return;
        }

        maxHeap.deleteMaxNum(countMap.keySet());
        countMap.remove(maxNum);
    }

    void deleteMinNum() {
        if (isEmpty()) return;

        int minNum = getMinNum();
        int count = countMap.get(minNum);
        if (--count > 0) {
            countMap.put(minNum, count);
            return;
        }

        minHeap.deleteMinNum(countMap.keySet());
        countMap.remove(minNum);
    }

    int getMaxNum() {
        return maxHeap.getMaxNum(countMap.keySet());
    }

    int getMinNum() {
        return minHeap.getMinNum(countMap.keySet());
    }

    boolean isEmpty() {
        return countMap.isEmpty();
    }
}

class MaxHeap {
    int size = 0;
    int[] heap;

    MaxHeap (int size) {
        this.heap = new int[size + 1];
    }

    void insert(int num) {
        heap[++size] = num;

        for (int i = size; i > 1; i /= 2) {
            int parentsIdx = i / 2;
            if (heap[parentsIdx] < heap[i]) swap(parentsIdx, i);
            else break;
        }
    }

    void deleteMaxNum(Set<Integer> numSet) {
        // 이미 삭제된 상태는 패스
        while (!numSet.contains(heap[size])) {
            heap[size--] = 0;
        }

        heap[1] = heap[size];
        heap[size--] = 0;

        for (int i = 1; i * 2 <= size;) {            
            int leftChildIdx = i * 2, rightChildIdx = leftChildIdx + 1;
            int swapIdx = size == leftChildIdx
                || heap[leftChildIdx] > heap[rightChildIdx]
                ? leftChildIdx : rightChildIdx;

            if (heap[i] >= heap[swapIdx]) break;
            swap(i, swapIdx);
            i = swapIdx;
        }
    }

    int getMaxNum(Set<Integer> numSet) {
        // 이미 삭제된 상태면 heap에서도 삭제
        while (!numSet.contains(heap[1])) {
            deleteMaxNum(numSet);
        }

        return heap[1];
    }

    void swap(int fromIdx, int toIdx) {
        int temp = heap[fromIdx];
        heap[fromIdx] = heap[toIdx];
        heap[toIdx] = temp;
    }
}

class MinHeap {
    int size = 0;
    int[] heap;

    MinHeap (int size) {
        this.heap = new int[size + 1];
    }

    void insert(int num) {
        heap[++size] = num;

        for (int i = size; i > 1; i /= 2) {
            int parentsIdx = i / 2;

            if (heap[parentsIdx] > heap[i]) swap(parentsIdx, i);
            else break;
        }
    }

    void deleteMinNum(Set<Integer> numSet) {
        // 이미 삭제된 상태는 패스
        while (!numSet.contains(heap[size])) {
            heap[size--] = 0;
        }

        heap[1] = heap[size];
        heap[size--] = 0;

        for (int i = 1; i * 2 <= size;) {            
            int leftChildIdx = i * 2, rightChildIdx = leftChildIdx + 1;
            int swapIdx = size == leftChildIdx
                || heap[leftChildIdx] < heap[rightChildIdx]
                ? leftChildIdx : rightChildIdx;

            if (heap[i] <= heap[swapIdx]) break;

            swap(i, swapIdx);
            i = swapIdx;
        }
    }

    int getMinNum(Set<Integer> numSet) {
        // 이미 삭제된 상태면 heap에서도 삭제
        while (!numSet.contains(heap[1])) {
            deleteMinNum(numSet);
        }

        return heap[1];
    }

    void swap(int fromIdx, int toIdx) {
        int temp = heap[fromIdx];
        heap[fromIdx] = heap[toIdx];
        heap[toIdx] = temp;
    }
}