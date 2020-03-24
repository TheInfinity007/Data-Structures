/*
Find the kth smallest element in the binary search tree
Given a binary search tree and a number k, print the kth smallest number in tree.

Input
The root node of binary search tree is given to you. Do not write the whole program, just complete the function int kSmallest(Node root, int k) which takes the address of the root node of tree and an integer k as parameters and return the kth smallest number from tree.
Note: Do not read any input from stdin/console. Just complete the function provided. You can write more functions if required, but just above the given function.

Output
Print the kth smallest number from tree.

*/

import java.util.ArrayList;
class Main
{
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 25);
        insert(root, 15);
        insert(root, 50);
        insert(root, 10);
        insert(root, 22);
        insert(root, 35);
        insert(root, 70);
        
        System.out.println("Printing the inorder traversal of BST:");
        printInorder(root);

        
        System.out.println("\nThe 1st Smallest node is : " + kSmallest(root, 1));
        System.out.println("The 2nd Smallest node is : " + kSmallest(root, 2));
        System.out.println("The 3rd Smallest node is : " + kSmallest(root, 3));
        System.out.println("The 4th Smallest node is : " + kSmallest(root, 4));
        System.out.println("The 5th Smallest node is : " + kSmallest(root, 5));
        System.out.println("The 6th Smallest node is : " + kSmallest(root, 6));
        System.out.println("The 7th Smallest node is : " + kSmallest(root, 7));
        System.out.println("The 8th Smallest node is : " + kSmallest(root, 8));

    }

    static int kSmallest(Node node, int k)
    {
        if(node == null)
            return -1;
        ArrayList <Integer>arr = new ArrayList<Integer>();
        traverseInorder(node, arr, k);
        if(arr.size() < k)
            return -1;
        return arr.get(k-1);
    }

    static void traverseInorder(Node node, ArrayList<Integer>arr, int k)
    {
        if(node != null)
        {
            traverseInorder(node.left, arr, k);
            if(arr.size() == k)
                return;
            arr.add(node.data);
            traverseInorder(node.right, arr, k);
        }
    }


    public static Node insert(Node node, int data)
    {
        if(node == null)
            return new Node(data);
        if(data < node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
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