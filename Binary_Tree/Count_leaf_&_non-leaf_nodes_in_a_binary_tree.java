/*
Count the number of leaf and non-leaf nodes in a binary tree
A leaf in a tree is a node which has no children, i.e. for a binary tree, both its left and right point to NULL. Given a binary tree count the number of leaf and non-leaf nodes in it.
Complete the functions countLeafs() & countNonLeafs() which takes the address of the root node as parameter and return the count of the leaves and non-leafs respectively.
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
        root = buildTree(arr, n);       //build tree level wise

        System.out.println("\nPrinting Tree with Level Wise Traversal");
        printLevelWise(root);

        System.out.println("\nThe no of leaves nodes is : " + countLeafs(root));
        System.out.println("The no of leaves nodes Using recursion is : " + countLeafsUsingRecursion(root));
        System.out.println("The no of non-leave nodes is : " + countNonLeafs(root));
        System.out.println("The no of non-leave nodes using Recursion is : " + countNonLeafsUsingRecursion(root));
    }

    static int countLeafs(Node root) {
        java.util.Stack<Node> stk = new java.util.Stack<Node>();
        int count = 0;
        if(root == null)
          return count;
        Node curr;
        stk.push(root);
        while(stk.size() != 0)
        {
          curr = stk.pop();
          if(curr.left == null && curr.right == null)
              count++;
          else
          {
            if(curr.left != null)
              stk.push(curr.left);
            if(curr.right !=  null)
              stk.push(curr.right);
          }
        }
        return count;
    }

    static int countLeafsUsingRecursion(Node node)
    {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        else
            return countLeafsUsingRecursion(node.left) + countLeafsUsingRecursion(node.right);
    }
    static int countNonLeafs(Node root) 
    {
        java.util.Stack <Node> stk = new java.util.Stack<Node>();
        int count = 0;
        if(root == null)
        return count;
        Node curr;
        stk.push(root);
        while(stk.size() != 0)
        {
            curr = stk.pop();
            if(curr.left == null && curr.right == null)
                continue;    
            else
            {
                if(curr.left != null)
                stk.push(curr.left);
                if(curr.right !=  null)
                stk.push(curr.right);
                count++;
            }
        }
        return count;
    }
    static int countNonLeafsUsingRecursion(Node node)
    {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 0;
        else
            return 1 + countNonLeafsUsingRecursion(node.left) + countNonLeafsUsingRecursion(node.right);
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