/*
Find out if the tree can be folded or not
A tree can be folded if left and right sub-trees of root are structure wise mirror images. Now, given a binary tree, Find out if it can be folded or not.
Note: Tree with 0 or 1 node is folded inherently.
Complete the function isFoldable() which takes the address of the root as parameter and return 1 if tree can be folded and 0 otherwise.

Input Format
First line contains the number of nodes and second line contains the node values separated by space.

Output Format
For each test case, print 1 if tree is foldable and 0 otherwise, in new lines.
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

        int res = isFoldable(root);
        if(res == 1)
            System.out.println("The Tree is Foldable");
        else
            System.out.println("The tree is not foldable");
    }

    static int isFoldable(Node node)
    {
        boolean res;
        if(node == null)
            return 1;
        mirror(node.left);

        res = isStructSame(node.left, node.right);
        mirror(node.left);

        if(res)
            return 1;
        return 0;
    }
    static boolean isStructSame(Node a, Node b)
    {
        if(a == null && b == null)
            return true;   //true
        if(a != null && b != null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right))
            return true;
        
        return false;
    }
    static void mirror(Node node)
    {
        if(node == null)
            return;
        Node temp = null;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
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