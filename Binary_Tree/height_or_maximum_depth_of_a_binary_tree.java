/*
Find maximum depth or height of a binary tree
Height of a tree is defined as the length of the longest downward path from root node to any leaf. If tree is empty, height is considered as -1 and for tree with only one node height is considered as 0.
Your task is that given a binary tree, find out the maximum depth of tree (also called height of tree).
Complete the function treeHeight() which takes the address of the root node of tree as parameter and return the height of the tree.

Input Format
First line contains the number of nodes in tree and second line contains the node vales in level-wise order.

Output Format
For each test case, print the height of tree.
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
        root = buildTree(arr, root, 0);

        System.out.println("\nPrinting Tree with Level Wise Traversal");
        printLevelWise(root);

        System.out.println("The Height of the tree is : " + treeHeight(root));    
    }

    static int treeHeight(Node node)
    {
        if(node == null)
            return -1;
        return getMaxHeight(node, 0);
    }
    static int getMaxHeight(Node node, int height)
    {
        int height1;
        int height2;
        if(node == null || (node.left == null && node.right == null))
            return 0;
        height1 = 1 + getMaxHeight(node.left, height);
        height2 = 1 + getMaxHeight(node.right, height);

        if(height2 > height1)
            return height2;
        return height1;
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

    static Node buildTree(int arr[], Node root, int i)
    {
        if(i < arr.length)
        {
            root = new Node(arr[i]);
            root.left = buildTree(arr, root.left, 2*i+1);
            root.right = buildTree(arr, root.right, 2*i+2);
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