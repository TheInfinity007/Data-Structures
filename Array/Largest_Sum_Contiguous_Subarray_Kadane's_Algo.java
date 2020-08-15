// Largest_Sum_Contiguous_Subarray
// Algo Used - Kadane's_Algo

/**
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */

import java.util.Scanner;
class Main
{
    public static void main(String[] args){
        String input = "8\n-2 -3 4 -1 -2 1 5 1";
        // String input = "5\n-1 -2 -3 -7 -9";
        Scanner sc = new Scanner(input);

        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        System.out.println(n);

        int arr[] = new int[n];
        System.out.println("Enter array Elements: ");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
            System.out.print(arr[i] + " ");
        }

        System.out.println("The maximum Contiguous Array Sum is " + maxSubArraySum(arr));
    }
    

    static int maxSubArraySum(int arr[])
    {
        int maxSum = arr[0], currentSum = arr[0], s = 0, e = 0, ts=0;
        for(int i = 0; i < arr.length; i++)
        {
            currentSum += arr[i];
            if(arr[i] > currentSum){
                currentSum = arr[i];
                ts = i;
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
                s = ts;
                e = i;
            }
            System.out.println(i + "\t" + ts + " " +s +" " +  e);
        }
        System.out.println("\n\nStarting index is : " + s +"\nEnding index is e: " + e);
        return maxSum;
    }
}