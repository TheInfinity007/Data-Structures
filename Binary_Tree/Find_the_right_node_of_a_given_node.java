/*
Find the right node of a given node
Given a binary tree and a key in it, find the node which is on same level and on right of this given key. If no such node present return -1.
Complete the function findRightSibling() which takes the address of the root node and an integer key as a parameter and return the right sibling (if exists, otherwise return -1).

Input Format
First Line contains the number of nodes and second line contains the node labels in level-order fashion. Third line contains an integer k whose right sibling is desired.

Output Format
Print the right sibling if any, otherwise print -1.

Sample Input
6
1 2 3 4 5 6
2

Sample Output
3
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Main
{
    public static void main(String[] args)
    {
        String input = "6\n1 2 3 4 5 6";
        Scanner sc = new Scanner(input);
        int n, i;

        System.out.println("Enter the no of nodes");
        n = sc.nextInt();
        System.out.println(n);

        System.out.println("Enter the elements");
        int arr[]=new int[n];
        for(i=0; i < n; i++){
            arr[i] = sc.nextInt();
            System.out.print(arr[i] + " ");
        }
        
        Node root = null;
        root = buildTree(arr, n);

        System.out.println("\nPrinting Tree with Level Wise Traversal");
        printLevelWise(root);

        System.out.println("\nThe right node of 1 is: " + findRightSibling(root, 1));
        System.out.println("The right node of 2 is: " + findRightSibling(root, 2));
        System.out.println("The right node of 3 is: " + findRightSibling(root, 3));
        System.out.println("The right node of 4 is: " + findRightSibling(root, 4));
        System.out.println("The right node of 5 is: " + findRightSibling(root, 5));
        System.out.println("The right node of 6 is: " + findRightSibling(root, 6));
    }

    static int findRightSibling(Node root, int key)
    {
        if(root == null)
            return -1;
        Queue<Node>q = new LinkedList<Node>();
        Node node = null;
        q.add(root);
        q.add(node);
        while(q.size() != 0)
        {
            if(node == null);   //do nothing
            else
            {
                q.add(node.left);
                q.add(node.right);

                if(q.peek() == null)
                    q.add(null);

                if(node.data == key && q.peek() != null)
                    return q.peek().data;
                if(node.data == key && q.peek() == null)
                    return -1;                    
            }
            node = q.poll();
        }
        return -1;
    }

    static void printLevelWise(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        Node node = null;
        q.add(root);
        q.add(node);
        Node curr = q.poll();
        while(q.size() != 0)
        {
            if(curr == null);   //do nothing
            else
            {
                q.add(curr.left);           //add its child to queue
                q.add(curr.right);
                
                if(q.peek() == null){       //if next is null print \n
                    System.out.println(curr.data);
                    q.add(null);
                }      	
                else
                    System.out.print(curr.data + " ");      
            }      
            curr = q.poll();
        }
    }


    static Node buildTree(int arr[], int n)
    {
        Node node = null;
        if(n < 1)               //if array is empty;
            return node;
        Queue <Node> q = new LinkedList<Node>();
        Node root = new Node(arr[0]);       //add first element to the root
        q.add(root);
        node = root;
        
        for(int i = 1; i < n; i++)
        {
            if(node.left == null)
            {
                node.left = new Node(arr[i]);
                q.add(node.left);
            }
            else
            {
                node.right = new Node(arr[i]);
                q.add(node.right);
                q.poll();
                node = q.peek();
            }
        }
        return root;
    }
}
class Node
{
  int data; // data used as key value
  Node left;
  Node right;
  public Node(){};
  public Node(int d)
  {
    data=d;
  }
}