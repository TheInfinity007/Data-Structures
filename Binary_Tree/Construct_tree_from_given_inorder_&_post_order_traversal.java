/*
Construct tree from given inorder and post order traversal
Given two array representing the inorder and postorder traversal of a binary tree, construct the tree and print the preorder of it.

*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Main
{
    public static void main(String[] args)
    {
        String input = "6\n4 2 5 1 6 3\n4 5 2 6 3 1";
        Scanner sc = new Scanner(input);
        int n, i;

        System.out.println("Enter the no of nodes");
        n = sc.nextInt();
        System.out.println(n);

        System.out.println("Enter the Inorder Traversal");
        int inorder[]=new int[n];
        for(i=0; i < n; i++){
            inorder[i] = sc.nextInt();
            System.out.print(inorder[i] + " ");
        }
            

        System.out.println("\nEnter the Postorder Traversal");
        int postorder[]=new int[n];
        for(i=0; i < n; i++){
            postorder[i] = sc.nextInt();
            System.out.print(postorder[i] + " ");
        }

        Node root = null;
        root = buildTree(inorder, postorder, n);

        System.out.println("\nPrinting Tree with PreOrder Traversal");
        printPreorder(root);
    }

    static Node buildTree(int in[], int post[], int N)
    {
        Index pIndex = new Index();
        pIndex.index = N-1;
        return buildUntil(in, post, 0, N-1, pIndex);
    }
    static Node buildUntil(int in[], int post[], int start, int end, Index pIndex)
    {
        if(start > end)
        return null;
        
        Node node = new Node(post[pIndex.index]);
        int iIndex = getIndex(in, start, end, node.data);
        
        (pIndex.index)--;
        if(start == end)
        return node;
        
        node.right = buildUntil(in, post, iIndex+1, end, pIndex);
        node.left = buildUntil(in, post, start, iIndex-1, pIndex);
        
        return node;
    }
    static int getIndex(int in[], int start, int end, int num)
    {
        for(int i = start; i <= end; i++)
        {
        if(in[i] == num)
            return i;
        }
        return -1;
    }


    static void printPreorder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }
}
class Index
{
  int index;
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