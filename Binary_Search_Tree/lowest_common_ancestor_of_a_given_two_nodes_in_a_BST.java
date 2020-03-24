/*


Find a lowest common ancestor of a given two nodes in a binary search tree
By : Girdhar Gopal  

The Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST) is defined as the deepest node from the root which lies in the path of both the nodes from the root.
So, given a binary search tree, find the Lowest Common Ancestor of two nodes in it
Complete the function lowestCommonAncestor() which takes the address of the root node of tree and two integer keys as parameters and return the lowest common ancestor of these two nodes (For null tree return -1).
You can assume that both these data are present in the tree and are different from each other.

Input Format
First line contain the number of nodes in tree. Second line contains the node labels in level-order fashion. Third line contains two integers k1 and k2 separated by space.

Output Format
Print the lowest common ancestor of given two nodes from the binary search tree.

Sample Input
7
4 2 7 1 3 5 8
1 5

Sample Output
4

Explanation
       4
      /  \
     2    7
    / \  / \
   1  3 5   8
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
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

        System.out.println("\nThe lowest Common ancestor of 1 and 5 is " + lowestCommonAncestor(root, 1, 5));
    }

    static int lowestCommonAncestor(Node root, int k1, int k2) 
    {
        if(root == null)
            return -1;
        Queue <Node> q1 = new LinkedList<Node>();
        Queue <Node> q2 = new LinkedList<Node>();

        search(root, k1, q1);
        search(root, k2, q2);
        Node res = null;
        while(q1.size() != 0 && q2.size() != 0)
        {
            if(q1.peek() == q2.peek())
            {
                res = q1.poll();
                q2.poll();
            }
            else
                break;
        }
        return res.data;
    }

    static void search(Node node, int k, Queue<Node>q)
    {
        if(node != null)
        	q.add(node);
        if(node == null || node.data == k)
            return;
        if(node.data > k)
            search(node.left, k, q);
        else
            search(node.right, k, q);
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