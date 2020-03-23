/*
Evaluation of expression tree
Given a expression binary tree with 4 binary operators (+, -, *, /) and integer operands, evaluate it and print the answer.
Complete the function evaluateTree() which takes the address of the root node of tree as parameter and return the result of expression.
Note: The nodes with operators are given as ASCII codes of these operators (e.g. 42 for *(multiply), 43 for +(addition), 45 for -(subtraction) & 47 for /(division)).

Input Format
First line contains the total number of nodes and second line contains the node labels separated by space.

Output Format
For each test case, print the result of expression, in new lines.

Sample Input
7
43 42 43 4 5 2 4

Sample Output
26

Explanation
      +
     / \
    *   +
   / \  / \
  4  5  2  4
Nodes which are having child nodes are the operator nodes and leaf nodes are the operand nodes to distinguish between.
*/
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Main
{
    public static void main(String[] args)
    {
        String input = "7\n43 42 43 4 5 2 4";
        Scanner sc = new Scanner(input);
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

        System.out.println("The result is : " + evaluateTree(root));
    }

    static int evaluateTree(Node node) {
        if(node == null)
            return 0;
        int a, b, operator, res;
        if(node.left == null || node.right == null)
            return node.data;
        
        a = evaluateTree(node.left);
        b = evaluateTree(node.right);
        operator = node.data;
        res = solveExpression(a, b, operator);
        return res;
    }
    static int solveExpression(int a, int b, int operator)
    {
        char op = (char)operator;
        switch(op)
        {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
            case '^': return (int)Math.pow(a,b);
        }
        return 0;
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
