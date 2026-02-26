import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MinHeap minHeap = new MinHeap(N);
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                sb.append(minHeap.delete()).append("\n");
            } else {
                minHeap.insert(x);
            }
        }

        System.out.print(sb);
        br.close();
    }

    static void addMinHeap(int num) {

    }
}

class MinHeap {
    int maxSize;
    int heapSize = 0;
    int[] heap;

    MinHeap (int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize + 1];
    }

    void insert(int num) {
        heap[++heapSize] = num;

        for (int i = heapSize; i > 1; i /= 2) {
            int parentsIdx = i / 2;
            if (heap[parentsIdx] > heap[i]) swap(parentsIdx, i);
            else break;
        }
    }

    int delete() {
        if (heapSize == 0) return 0;
        int num = heap[1];

        heap[1] = heap[heapSize];
        heap[heapSize--] = 0;

        for (int i = 1; i * 2 <= heapSize;) {            
            int leftChildIdx = i * 2, rightChildIdx = leftChildIdx + 1;
            if (heapSize == leftChildIdx && heap[i] <= heap[leftChildIdx]) break;
            if (heap[i] <= heap[leftChildIdx] && heap[i] <= heap[rightChildIdx]) break;

            if (heapSize == leftChildIdx || heap[leftChildIdx] < heap[rightChildIdx]) {
                swap(i, leftChildIdx);
                i = leftChildIdx;
            } else {
                swap(i, rightChildIdx);
                i = rightChildIdx;
            }
        }

        return num;
    }

    void swap(int fromIdx, int toIdx) {
        int temp = heap[fromIdx];
        heap[fromIdx] = heap[toIdx];
        heap[toIdx] = temp;
    }
}