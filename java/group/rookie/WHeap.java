
package group.rookie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WHeap<T extends Comparable> {


    private List<T> data;

    private boolean isBigProof =  true;

    public WHeap() {
        data = new ArrayList<>();
    }
    public void createHeap(List<T> elements) {
        int n = elements.size();
        for (int i = n/2; i >= 1; --i) {
            heapify(elements, n, i);
        }
    }

    private void heapify(List<T> elements, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && elements.get(i).compareTo(elements.get(i * 2)) > 0) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && elements.get(maxPos).compareTo(elements.get(i * 2 + 1)) > 0) {
                maxPos = i * 2 + 1;
            }
            swap(elements, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(List<T> elements, int i, int maxPos) {
        T temp = elements.get(i);
        elements.set(i, elements.get(maxPos));
        elements.set(maxPos, temp);
    }


    public static void main(String[] args) {
        WHeap<Integer> heap = new WHeap<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(6);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        heap.createHeap(arr);
        System.out.println(arr);
    }
}