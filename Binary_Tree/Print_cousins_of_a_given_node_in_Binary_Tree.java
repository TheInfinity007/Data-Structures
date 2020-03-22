/*
Print cousins of a given node in Binary Tree
Given a binary tree and a key value from this tree, print all the cousins of this node separated by space. If no cousin exists print -1.

Complete the function printCousins() which takes the address of the root node and a key k as a parameter and print the cousins of k separated by space or -1 if no cousin exists.

Input Format
First line contains the total number of nodes, second line contains the node labels separated by space. Third line contains an integer key k whose cousins are desired.

Output Format
For each test case, print the cousins of given key separated by space in new lines.
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, i;

        System.out.println("Enter the no of nodes");
        n = sc.nextInt();

        System.out.println("Enter the elements");
        int arr[]=new int[n];
        for(i=0; i < n; i++)
            arr[i] = sc.nextInt();

        Node root = null;
        root = buildTree(arr, n);

        System.out.println("\nPrinting Tree with Level Wise Traversal");
        printLevelWise(root);

        System.out.println("Printing cousins of node 6 ");
        printCousins(root, 6);
    }

    static void printCousins(Node node, int key)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        q.add(null);
        int found = 0;
        int print = 0;
        int count = 0;
        while(q.size() != 0)
        {            
            node = q.poll();
            if(node == null){
                if(found == 1)
                    print = 1;
            }
            else if(print == 1)
            {
                System.out.print(node.data + " ");
                count++;
            }
            else
            {
                if((node.left != null && node.left.data == key) || (node.right != null && node.right.data == key))
                {
                    found = 1;
                }
                else
                {
                    q.add(node.left);
                    q.add(node.right);
                    if(q.peek() == null)
                        q.add(null);
                }
            }
        }
        if(count == 0)
            System.out.println(-1);
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