class MinHeap
{
    int heap[] = new int[100];
    int heapSize = -1;

    void insert(int element)
    {
        heap[++heapSize] = element;
        int now = heapSize;
        while(heap[(now-1)/2] > element)
        {
            heap[now] = heap[(now-1)/2];
            now = (now-1)/2;
        }
        heap[now] = element;
    }

    int deleteMin()
    {
        int min, lastElement, child, now;
        
        min = heap[0];
        lastElement = heap[heapSize--];

        for(now = 0; now*2 < heapSize; now = child)
        {
            //child is the left node of the parent and  child+1 is the right child of the parent node
            child = now*2+1;
            if(child != heapSize && heap[child] > heap[child+1])
                child++;
            
            //check if the lastElement fits or not in the root
            if(lastElement > heap[child])
                heap[now] = heap[child];
            else
                break;
        }
        heap[now] = lastElement;
        return min;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(40);
        heap.insert(15);

        int i;
        System.out.println("Heap array after inserting 10, 40, 15 elements : ");
        for(i = 0; i <= heap.heapSize; i++)
            System.out.print(heap.heap[i] + " ");

        heap.insert(30);

        System.out.println("\nHeap array after inserting 10, 40, 15, 30 elements : ");
        for(i = 0; i <= heap.heapSize; i++)
            System.out.print(heap.heap[i] + " ");

        heap.insert(25);

        System.out.println("\nHeap array after inserting 10, 40, 15, 30, 25 elements : ");
        for(i = 0; i <= heap.heapSize; i++)
            System.out.print(heap.heap[i] + " ");
        
        heap.insert(31);
        System.out.println("\nHeap array after inserting 10, 40, 15, 30, 25, 31 elements : ");
        for(i = 0; i <= heap.heapSize; i++)
            System.out.print(heap.heap[i] + " ");

        System.out.println();    
        System.out.println("Elements deleted from heap in following order : ");
        for (i = heap.heapSize; i >= 0; i--)
           System.out.print(heap.deleteMin() + " ");
    }
}