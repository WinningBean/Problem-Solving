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

    int delete() {
        if (size == 0) return 0;
        int num = heap[1];

        heap[1] = heap[size];
        heap[size--] = 0;

        for (int i = 1; i * 2 <= size;) {            
            int leftChildIdx = i * 2, rightChildIdx = leftChildIdx + 1;
            int swapIdx = size == leftChildIdx || heap[leftChildIdx] < heap[rightChildIdx] ? leftChildIdx : rightChildIdx;

            if (heap[i] <= heap[swapIdx]) break;

            swap(i, swapIdx);
            i = swapIdx;
        }

        return num;
    }

    void swap(int fromIdx, int toIdx) {
        int temp = heap[fromIdx];
        heap[fromIdx] = heap[toIdx];
        heap[toIdx] = temp;
    }
}