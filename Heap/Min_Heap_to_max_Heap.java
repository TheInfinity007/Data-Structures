/*
Convert min Heap to max Heap

Given array representation of a min-heap convert it in a max-heap representation. For example, if array a = [13 15 19 16 18 120 110 112 118] the array must be modified as a = [120 118 110 112 18 19 13 15 16].

Input
First line of input contain T = number of test cases. Each test case contain two lines, in first line, total number of elements in array and next line will contain the elements.

The array of numbers is given to you. Do not write the whole program, just complete the functions void modifyMintoMax(int array[], int n) which takes the array and total number of elements n as parameters and modify the array elements with heapify() to convert it in max-heap.
Note: Do not read any input from stdin/console. Just complete the functions provided. You can write more functions if required, but just above the given function.

Output
For each test case, print the max-heap elements separated by space in new lines.

Sample Input
2
9
13 15 19 16 18 120 110 112 118
6
1 2 3 4 5 6

Sample Output
120 118 110 112 18 19 13 15 16
6 5 3 4 2 1
*/

import java.util.Scanner;
class Main
{
    public static void main(String[] args) {
        String input = "2\n9\n13 15 19 16 18 120 110 112 118\n6\n1 2 3 4 5 6";
        Scanner sc = new Scanner(input);
        int tCase = sc.nextInt();
        System.out.println("No of testcase: "+ tCase);
        while(tCase > 0)
        {
            int n = sc.nextInt();
            System.out.println("Size of array : " + n);

            int arr[] = new int[n];

            System.out.println("The input array is : ");
            for(int i = 0; i < n; i++)
            {
                int x = sc.nextInt();
                arr[i] = x;
                System.out.print(x + " ");
            }
            System.out.println();

            modifyMintoMax(arr, n);
            System.out.println("After modification : ");
            for(int i: arr)
                System.out.print(i + " ");
            
            System.out.println();    
            tCase--;
        }
    }

    int heap[] = new int[100];
    int heapSize = -1;

    void insert(int element)        //insert maxheap
    {
        heap[++heapSize] = element;
        int now = heapSize;
        while(heap[(now-1)/2] < heap[now])
        {
            heap[now] = heap[(now-1)/2];
            heap[(now-1)/2] = element;
            now = (now-1)/2;
        }
    }

    int deleteMax()
    {
        int max, now, lastElement, child;
        max = heap[0];
        lastElement = heap[heapSize--];
        heap[0] = lastElement;
        for(now = 0; now*2 < heapSize; now = child)
        {
            child = now*2+1;
            if(child != heapSize && heap[child] < heap[child+1])
                child++;
            
            if(heap[child] >= lastElement)
                heap[now] = heap[child];
            else
                break;
        }
        heap[now] = lastElement;
        return max;
    }

    static void modifyMintoMax(int array[], int n)
    {
        Main maxHeap = new Main();
        for(int i = 0; i < n; i++)
            maxHeap.insert(array[i]);

        System.out.println("After insertion: ");
        for(int i = 0; i < n; i++)
            System.out.print(maxHeap.heap[i] + " ");
        System.out.println();
        
        for(int i = 0; i < n; i++)
        {
            array[i] = maxHeap.heap[i];
        }    
    }
}