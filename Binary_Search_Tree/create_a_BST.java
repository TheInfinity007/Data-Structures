
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