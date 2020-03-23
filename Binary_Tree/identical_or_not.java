/*
Given two trees are identical or not
Given two binary trees, find out both are same or not. Two trees are considered same if they have same nodes and same structure.
So complete the function areSameTree() which takes the address of the root nodes of two trees as parameters and return 1 if both are same and 0 otherwise.

Input Format
First line contains the number of nodes in first tree and second line contains the node labels in level-wise order.
Third line contains the number of nodes in second tree and fourth line contains the node labels in level-wise order.

Output Format
For each test case, print 1 if both tree are same and 0 otherwise.
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

        System.out.println("Enter the no of nodes in First tree");
        n = sc.nextInt();

        System.out.println("Enter the elements");
        int arr1[]=new int[n];
        for(i=0; i < n; i++)
            arr1[i] = sc.nextInt();

        System.out.println("Enter the no of nodes in Second tree");
        n = sc.nextInt();

        System.out.println("Enter the elements");
        int arr2[]=new int[n];
        for(i=0; i < n; i++)
            arr2[i] = sc.nextInt();

        Node root1 = null;
        root1 = buildTree(arr1, root1, 0);
        
        Node root2 = null;
        root2 = buildTree(arr1, root2, 0);

        System.out.println("\nPrinting Tree1 with Level Wise Traversal");
        printLevelWise(root1);

        System.out.println("\nPrinting Tree2 with Level Wise Traversal");
        printLevelWise(root2);

        int res = areSameTree(root1, root2);
        if(res == 1)
            System.out.println("The Trees are same");
        else
            System.out.println("The tree are not same");
    }

    static int areSameTree(Node node1, Node node2)
    {
        boolean res;
        if(node1 == null && node2 == null)
            return 1;

        res = isStructAndDataSame(node1, node2);

        if(res)
            return 1;
        return 0;
    }
    static boolean isStructAndDataSame(Node a, Node b)
    {
        if(a == null && b == null)
            return true;   //true
        if(a != null && b != null && a.data == b.data && isStructAndDataSame(a.left, b.left) && isStructAndDataSame(a.right, b.right))
            return true;
        
        return false;
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