/*
Check if a given tree is max-heap or not
A max-heap is a kind of tree which must satisfy the property as “Every node’s value should be greater than its children’s value”.

Your task is given level wise array representation of a binary tree, check if it is a max-heap or not.\
Complete the functions isMaxHeap() which takes the array and total number of elements n as parameters and return 1 if array represents a max-heap and 0 otherwise.

Input Format
First line of input contain T = number of test cases. Each test case contain two lines, in first line, total number of elements in tree and next line will contain the elements in level order fashion.

Output Format
For each test case, print 1 if array represents max-heap or 0 otherwise in new lines.
*/



	//Count the no of swaps in heapification. if total swap is equal to zero then the heap is a max-heap otherwise it's not a max-heap.
import java.util.Scanner;
class Main
{
    public static void main(String[] args) {
        String input = "2\n9\n120 118 110 112 18 19 13 15 16\n6\n1 2 3 4 5 6";
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

            int res = isMaxHeap(arr, n);
            if(res == 0)
                System.out.println("The Heap is not a Max heap");
            else
                System.out.println("The Heap is a Max heap");
            
            System.out.println("\n");    
            tCase--;
        }
    }

    static int isMaxHeap(int array[], int n)
    {
        int swaps = 0;
        for(int i = (n-2)/2; i >= 0; --i)
        {
            swaps = heapify(array, i, n);        //heapify all the internal nodes
            if(swaps != 0)
                return 0;
        }
        return 1;
            

    }    
    static int heapify(int arr[], int i, int n)
    {
        int now, child, max = arr[i];
        int swaps = 0;
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
                swaps++;
            }
            else
                break;
        }
        return swaps;
    }
}