/*
Print nodes at odd levels of the binary tree  
Given a binary tree, print all nodes at odd levels of the tree. Assume the root node is at level 1 i.e. odd level.
Complete the function printOddLevels() which will take the root node of the tree as parameter and print the nodes at odd levels of the binary tree.
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

        System.out.println("\nPrinting Nodes at Odd Levels");
        printOddLevels(root);
    }

    static void printOddLevels(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        int num = 1;
        Node curr = q.poll();
        while(q.size() != 0)
        {
            if(curr == null)
                num++;
            else
            {
                q.add(curr.left);
                q.add(curr.right);
                
                if(num%2 == 1)
                    System.out.print(curr.data + " ");
                if(q.peek() == null)
                    q.add(null);
            }
            curr = q.poll();  
        }
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