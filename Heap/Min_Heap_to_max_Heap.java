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

    static void modifyMintoMax(int array[], int n)
    {
        for(int i = (n-2)/2; i >= 0; --i)
        {
            heapify(array, i, n);        //heapify all the internal nodes
            // maxHeapity(array, i, n);         //both methods work
        }
            

    }

    static void maxHeapify(int arr[], int i, int n)
    {
        int l, r, largest;
        largest = i;
        l = 2*i+1;
        r = 2*i+2;
        if(l < n && arr[l] > arr[largest])
            largest = l;
        if(r < n && arr[r] > arr[largest])
            largest = r;
        if(largest != i)    //Swap largest node with the ith node
        {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, largest, n);        //heapify all its 
        }
    }    
    static void heapify(int arr[], int i, int n)
    {
        int now, child, max = arr[i];
        
        for(now = i; now*2 <= n-2; now = child)
        {
            child = now*2+1;
            if(child+1 < n && arr[child] < arr[child+1])
                child++;
            if(arr[now] < arr[child])
            {
                int temp = arr[now];
                arr[now] = arr[child];
                arr[child] = temp;
            }
            else
                break;
        }
    }
}