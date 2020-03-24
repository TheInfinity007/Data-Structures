/*
Given binary tree is binary search tree or not 

A binary tree is called binary search tree if it holds following three properties: -
a. The left subtree of a node contains nodes whose keys are less than that node’s key.
b. The right subtree of a node contains nodes whose keys are greater than that node’s key.
c. Both the left and right subtrees must also be binary search trees.

Your task is that given a binary tree check if it is binary search tree or not. Complete the function isBinarySearchTree() which takes the address of the root node of tree as parameter and return 1 if the tree is binary search tree and 0 otherwise.
*/

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

        int res = isBinarySearchTree(root);
        if(res == 1)
            System.out.println("\nThe tree is BST");
        else
            System.out.println("\nThe tree is not a BST");
    }
    static int isBinarySearchTree(Node t1)
    {
        if(t1 == null)
            return 1;
        
        java.util.ArrayList<Integer>arr = new java.util.ArrayList<Integer>();
        traverseInorder(t1, arr);
        
        for(int i = 0; i < arr.size()-1; i++)
        {
            if(arr.get(i) > arr.get(i+1))
                return 0;
        }
        return 1;
    }
    static void traverseInorder(Node node, java.util.ArrayList<Integer>arr)
    {
        if(node != null)
        {
            traverseInorder(node.left, arr);
                arr.add(node.data);
                traverseInorder(node.right, arr);  
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