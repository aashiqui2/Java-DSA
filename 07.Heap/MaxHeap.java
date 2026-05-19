import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Insert a new value into the heap
    public void insert(int value) {
        heap.add(value); // Add value to the end
        heapifyUp(heap.size() - 1); // Adjust heap to maintain max-heap property
    }

    // Remove and return the maximum value (root)
    public int extractMax() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");

        int max = heap.get(0); // Root value
        int lastValue = heap.remove(heap.size() - 1); // Remove last element

        if (!heap.isEmpty()) {
            heap.set(0, lastValue); // Move the last value to the root
            heapifyDown(0); // Adjust heap to maintain max-heap property
        }

        return max;
    }

    // Helper method to maintain max-heap property (bottom-up)
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) > heap.get(parentIndex)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Helper method to maintain max-heap property (top-down)
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }

            if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Print the heap
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(40);

        System.out.println("Max-Heap:");
        maxHeap.printHeap();

        System.out.println("Extract Max: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}
