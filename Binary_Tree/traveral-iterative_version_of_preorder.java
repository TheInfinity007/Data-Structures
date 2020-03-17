/* 
Write iterative version of Preorder traversal
Given a binary tree, print it in Preorder fashion.
The root node of binary tree is given to you, and you have to complete the function void printPreorder(Node root) to print the nodes of tree. (The function should use iteration not recursion).
*/

import java.util.Scanner;
import java.util.Stack;
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

        System.out.println("Level Order Traversal");
        printLevelWise(root);

        System.out.println("PreOrder Traversal");
        printPreorder(root);
    }

    static void printPreorder(Node root)
    {
        Stack<Node> stk = new Stack<Node>();
        while(true){
            while(root != null)
            {
                System.out.print(root.data + " ");
                stk.push(root);
                root = root.left;
            }
            if(stk.size() == 0)
                break;
            root = stk.pop();
            root = root.right;
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
        for(int i = 1; i < n; i++){
            if(node.left == null){
                node.left = new Node(arr[i]);
                q.add(node.left);
            }
            else{
                node.right = new Node(arr[i]);
                q.add(node.right);
                q.poll();
                node = q.peek();
            }
        }
        return root;
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