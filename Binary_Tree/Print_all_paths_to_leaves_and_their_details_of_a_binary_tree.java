/*
Print all paths to leaves and their details of a binary tree
The root node of binary tree is given to you. A path from root to leaf in a tree is a sequence of adjacent nodes from root to any leaf node. Do not write the whole program, just complete the function void printAllPaths(Node root) which takes the address of the root as a parameter and print all details as shown below.

Sample Input

        1
       / \
      2    3
     / \  /
    4  5 6

Sample Output

1 2 4 2
1 2 5 2
1 3 6 2
3
Explanation

First path is from 1 to 4 having 2 edges, so 1 2 4 is path and 2 is length of it. 
Similarly for other two leaf nodes. And at last line total number of paths are printed.

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

        System.out.println("Printing all paths to the leaves");
        printAllPaths(root);
    }

    static void printAllPaths(Node root) 
    {
        if(root == null)
            return;
        //Traverse the tree in inorder way
        Stack<Temp> stk = new Stack<Temp>();
        int no_of_leaves = 0;   //no of path is equal to no of leaves
        stk.push(new Temp(root, 0, String.valueOf(root.data)));
        Node node = root.left;
        Temp obj = stk.peek();
        while(true)
        {
            while(node != null)
            {
                stk.push(new Temp(node, obj.distance+1, obj.toString()+ " " + String.valueOf(node.data)));
                node = node.left;
                obj = stk.peek();
            }
            if(stk.size() == 0)
            break;

            obj = stk.peek();
            node = stk.pop().node;
            if(node.left == null && node.right == null)
            {
                System.out.println(obj.toString() + " " + obj.distance);
                no_of_leaves++;
            }
            node = node.right;
        }
        System.out.println(no_of_leaves);
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
class Temp
{
    Node node;
    String str;
    int distance;
    Temp(Node node, int distance, String s){
        this.node = node;
        this.distance = distance;
        str = s;
    }
    public String toString(){
        return str;
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