/*
Convert Level Order Traversal to BST 
Given an array of integer elements representing the level order traversal of a binary search tree, create the binary search tree from this array.
Write the function buildSearchTree() which takes the array and total number of nodes as parameters and return the root of the binary search tree.

Input Format
First line contains the number of elements in the array(containing the level order traversal) and second line contains the elements separated by space.

Output Format
Print the tree with inorder traversal.

Sample Input
7
4 2 7 1 3 5 8

Sample Output
1 2 3 4 5 7 8
*/

import java.util.Scanner;
class Main
{
    public static void main(String[] args) {
        String input = "7\n4 2 7 1 3 5 8";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i< n; i++)
        {
            arr[i] = sc.nextInt();
        }
        Node root = buildSearchTree(arr, n);
        
        System.out.println("Printing the inorder traversal of BST:");
        printInorder(root);
    }

    static Node buildSearchTree(int t[], int n) 
    {
        Node root = null;
        for(int i = 0; i < t.length; i++)
        {
          root = insert(root, t[i]);
        }
        return root;
    }
  
    static Node insert(Node node, int key)
    {
        if(node == null)
            return new Node(key);
        if(node.data > key)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);
        return node;
    }

    static void printInorder(Node node)
    {
        if(node != null)
        {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }
}

class Node
{
  int data;
  Node left;
  Node right;
  public Node(){};
  public Node(int d)
  {
    data=d;
  }
}