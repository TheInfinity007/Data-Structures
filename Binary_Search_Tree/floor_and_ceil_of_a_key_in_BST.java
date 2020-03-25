/*
Find the floor and ceil of a key in binary search tree
Given a binary search tree, find the floor and ceil of an key in the tree. They are defined as below:
floor value of k: largest node value which is smaller than or equal to k.
ceil value of k: smallest node value which is greater than or equal to k.

Complete the functions floorOf() & ceilOf() which takes the address of the root node of tree and an integer key as parameters and return the floor and ceil of that key respectively, and -1 if not found.

Input Format
First line contains the number of nodes, second line contains the node labels in level-wise order. Third line contains an integer k whose floor and ceil are desired.

Output Format
Print the floor and ceil node values of given key from the binary search tree. If not exists, print -1.
*/

import java.util.Scanner;
import java.util.ArrayList;
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

        System.out.println();
        System.out.println("\nFloor of 6 is : " + floorOf(root, 6));
        System.out.println("Ceil of 9 is : " + ceilOf(root, 9));
    }

    static int floorOf(Node root, int key) 
    {
        Node node = search(root, key);
        if(node != null)
            return node.data;
        ArrayList<Integer>arr = new ArrayList<Integer>();
        traverseInorder(root, arr, key);
        if(arr.size() == 1)
            if(arr.get(0) < key)
                return arr.get(0);
            return -1;
        if(arr.get(arr.size()-1) < key)
            return arr.get(arr.size()-1);
        return arr.get(arr.size()-2);
    }
    static int ceilOf(Node root, int key) {
        Node node = search(root, key);
        if(node != null)
            return node.data;
        ArrayList<Integer>arr = new ArrayList<Integer>();
        traverseInorder(root, arr, key);
        if(arr.get(arr.size()-1) < key)
            return -1;
        return arr.get(arr.size()-1);
    }
    static void traverseInorder(Node node, ArrayList<Integer>arr, int key)
    {
        if(node != null)
        {
            traverseInorder(node.left, arr, key);
            if(arr.size() >=1 && arr.get(arr.size()-1) > key)
                return;
            arr.add(node.data);
            traverseInorder(node.right, arr, key);
        }
    }
    static Node search(Node node, int key)
    {
        if(node == null || node.data == key)
            return node;
        if(node.data > key)
            return search(node.left, key);
        return search(node.right, key);
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