/*
Print nodes in a top view of Binary Tree 
Given a binary tree, print top view of the binary tree.
Write a function printTopView() which takes the address of the root as a parameter and print the tree from top view.

Input Format
First line contains the number of nodes in tree and second line contains the node labels in level-order fashion.

Output Format
For each test case, print the tree nodes from top view separated by space in new lines.
*/


import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;


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
        root = buildTree(arr, n);       //level wise

        System.out.println("\nPrinting Tree with Level Wise Traversal");
        printLevelWise(root);

        System.out.println("Printing the top view: ");
        printTopView(root);
    }

    static void printTopView(Node root)
    {
        if(root == null)
            return;
        Queue <Temp> q = new LinkedList<Temp>();
        HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
        hm.put(0, root);
        q.add(new Temp(root, 0));
        Temp obj;
        while(q.size() != 0)
        {
            obj = q.poll();

            if(!(hm.containsKey(obj.distance)))
                hm.put(obj.distance, obj.node);
            if(obj.node.left != null)
                q.add(new Temp(obj.node.left, obj.distance-1));
            if(obj.node.right != null)
                q.add(new Temp(obj.node.right, obj.distance+1));
        }

        TreeMap<Integer, Node> sortedMap = new TreeMap<>();     //to sort the hashmap based on key
        sortedMap.putAll(hm);

        for(int i : sortedMap.keySet())
            System.out.print(sortedMap.get(i).data + " ");
            
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
    int distance;
    Node node;
    Temp(Node node, int d)
    {
        this.node = node;
        distance = d;
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