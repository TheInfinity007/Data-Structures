/*
Find K largest elements in array
Given an array of integer elements and an integer k, print the k largest elements from array separated by space in descending sorted order. For example, if array a = [2, 56, 3, 87, 42, 1, 45, 8, 2, 98] and k=3 then output must be 98 87 56.

Input
First line of input contain T = number of test cases. Each test case contain two lines, in first line, total number of elements in array and value of k are provided and next line will contain the elements.

The array of numbers and integer k is given to you.
Do not write the whole program, just complete the functions void printKLargest(int array[], int k) which takes the array and integer k as parameters and print the k largest elements in descending order separated by space.

Output
Print the k largest element in descending order separated by space.
Do not print the space after last element.
*/

import java.util.Scanner;
class Main
{
    public static void main(String[] args) {
        String input = "2\n10 3\n2 56 3 87 42 1 45 8 2 98\n6 2\n1 87 2 67 3 45";
        // String input = "1\n10 3\n2 56 3 87 42 1 45 8 2 98";
        Scanner sc = new Scanner(input);
        int tCase = sc.nextInt();
        System.out.println("No of testcase: "+ tCase);
        while(tCase > 0)
        {
            int n = sc.nextInt();
            System.out.println("Size of array : " + n);
            int arr[] = new int[n];
            int k = sc.nextInt();
            System.out.println("The input array is : ");
            for(int i = 0; i < n; i++)
            {
                int x = sc.nextInt();
                arr[i] = x;
                System.out.print(x + " ");
            }
            System.out.println();
            printKLargest(arr, n, k);
            System.out.println();
            tCase--;
        }
    }

    int heap[] = new int[100];
    int heapSize = -1;

    void insert(int element)
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
    
    static void printKLargest(int[] arr, int n, int k)
    {
        Main heap = new Main();
        for(int i = 0; i < n; i++)
            heap.insert(arr[i]);
        
        for(int i = 0; i < k-1; i++)
            System.out.print(heap.deleteMax() + " ");
        System.out.print(heap.deleteMax());
    }
}