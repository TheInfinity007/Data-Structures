/*
Connect the sticks of different lengths with minimum cost

Given n sticks of different length you have to connect them. The cost of connecting sticks is the sum of their length. You have to find the minimum cost for connecting all sticks. For example, if 3 sticks are there having length respectively 3, 6, 1 then we can connect them in many ways like:

Connect 3 and 6 (Cost 9), then we have 2 sticks of length 9 and 1 connect them (cost 10), So total cost is 19.
Connect 3 and 1 (Cost 4), then we have 2 sticks of length 4 and 6 connect them (cost 10), So total cost is 14.

So your function must return 14 in this case.
Complete the functions connectCost() which takes the array and total number of sticks as input and returns the minimum cost of connecting all these sticks.

Input Format
First line of input contain T = number of test cases.
Each test case contain two lines, in first line, total number of sticks and next line will contain the lengths of each stick.

Output Format
For each test case, print the total cost of connecting all sticks in new lines.

Sample Input
2
3
3 6 1
4
4 2 3 6

Sample Output
14
29
*/

import java.util.Scanner;
class Main
{
    public static void main(String[] args) {
        String input = "2\n3\n3 6 1\n4\n4 2 3 6";
        Scanner sc = new Scanner(input);
        int tCase = sc.nextInt();
        System.out.println("No of test Cases: " + tCase);
        while(tCase > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("The input array is : ");
            for(int i = 0; i < n; i++)
            {
                arr[i] = sc.nextInt();
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("\nThe connect Cost is : " + connectCost(arr, n));
            --tCase;
        }

    }

    int heap[] = new int[100];
    int heapSize = -1;

    void insert(int element)
    {
        heap[++heapSize] = element;
        int now = heapSize;
        while(heap[now] < heap[(now-1)/2])
        {
            heap[now] = heap[(now-1)/2];
            heap[(now-1)/2] = element;
            now = (now-1)/2;
        }
        
    }

    int deleteMin()
    {
        int min = heap[0];
        int now, child, lastElement;
        heap[0] = heap[heapSize--];
        lastElement = heap[0];
        for(now = 0; now*2 < heapSize; now = child)
        {
            child = now*2+1;
            if(child < heapSize && heap[child] > heap[child+1])
                child++;
            if(heap[child] < lastElement)
                heap[now] = heap[child];
            else
                break;
        }
        heap[now] = lastElement;
        return min; 
    }

    static int connectCost(int lengths[], int n)
    {
        if(n == 0)
            return 0;

        Main minHeap = new Main();

        for(int i = 0; i < n; i++)
            minHeap.insert(lengths[i]);
        
        if(n == 1)
            return minHeap.deleteMin();
        
        int length = minHeap.deleteMin();
        int cost = 0;
        for(int i = 1; i < n;i++)
        {
            length = length + minHeap.deleteMin();
            cost = cost + length;
        }
        return cost;
    }

}