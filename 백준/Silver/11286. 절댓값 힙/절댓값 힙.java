import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        AbsHeap absHeap = new AbsHeap(N);
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                sb.append(absHeap.delete()).append("\n");
            } else {
                absHeap.insert(x);
            }
        }

        System.out.print(sb);
        br.close();
    }
}

class AbsHeap {
    int size = 0;
    int[] heap;

    AbsHeap (int size) {
        this.heap = new int[size];
    }

    void insert(int num) {
        heap[++size] = num;

        for (int i = size; i > 1; i /= 2) {
            int parentsIdx = i / 2;
            int parentsAbs = Math.abs(heap[parentsIdx]), nowAbs = Math.abs(heap[i]);
            if (parentsAbs > nowAbs || (parentsAbs == nowAbs && heap[parentsIdx] > heap[i])) swap(parentsIdx, i);
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
            int leftChildAbs = Math.abs(heap[leftChildIdx]), rigtChildAbs = Math.abs(heap[rightChildIdx]);
            int swapIdx = size == leftChildIdx
                || leftChildAbs < rigtChildAbs
                || (leftChildAbs == rigtChildAbs && heap[leftChildIdx] < heap[rightChildIdx])
                ? leftChildIdx : rightChildIdx;

            int nowAbs = Math.abs(heap[i]), swapAbs = Math.abs(heap[swapIdx]);
            if (nowAbs < swapAbs || (nowAbs == swapAbs && heap[i] <= heap[swapIdx])) break;

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