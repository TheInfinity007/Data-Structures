/*
Convert a binary tree into its mirror tree
Given a binary tree, convert it in its mirror image. Mirror of a Binary Tree is another Binary Tree in which left and right children of all non-leaf nodes are interchanged.

Input
The root node of binary tree is given to you. Do not write the whole program, just complete the function findMirror(Node root) which takes the address of the root as a parameter and change the tree in its mirror image.
Note: Do not read any input from stdin/console. Just complete the function provided. You can write more functions if required, but just above the given function.

Output
For each test case, print the tree in inorder in new lines.
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
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

        System.out.println("Printing the mirror tree");
        root = findMirror(root);
        printLevelWise(root);

        System.out.println("Printing the inorder traversal");
        printInorder(root);
    }

    static Node findMirror(Node root)
    {
        if(root == null)
            return root;
        Queue<Node> q = new LinkedList<Node>();
        Node node = null;
        q.add(root);
        Node temp = null;
        while(q.size() != 0)
        {
            node = q.poll();
            if(node == null);   //do nothing
            else
            {
                temp = node.left;
                node.left = node.right;
                node.right = temp;
                q.add(node.left);
                q.add(node.right);
            }
        }
        return root;
    }
    static void printInorder(Node node)
    {
        if(node !=  null)
        {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
            
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