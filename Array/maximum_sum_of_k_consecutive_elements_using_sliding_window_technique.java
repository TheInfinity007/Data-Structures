// maximum_sum_of_k_consecutive_elements_using_sliding_window_technique

//Time Complexity O(n)

import java.util.Scanner;
class Main
{
    public static void main(String [] args){
        String input = "9\n-1 4 2 10 2 3 1 0 20\n3";
        Scanner sc = new Scanner(input);

        System.out.println("Array Size:");
        int n = sc.nextInt();
        System.out.println(n);

        int arr[] = new int[n];
        System.out.println("Enter Array Elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nEnter the size of window:");
        int k = sc.nextInt();
        System.out.println(k);

        System.out.println("\nMaximum sum of "+ k +" consecutive Elements is " + maxSum(arr, arr.length, k));
    }

    static int maxSum(int arr[], int n, int k)  
    {
        int maxSum = 0, windowSum = 0;
        for(int i = 0; i < k; i++)
        {
            maxSum += arr[i];
        }
        windowSum = maxSum;
        for(int i = k; i < n; i++)
        {
            windowSum += arr[i] - arr[i-k];
            if(windowSum > maxSum)
                maxSum = windowSum;
        }
        return maxSum;
    }
}