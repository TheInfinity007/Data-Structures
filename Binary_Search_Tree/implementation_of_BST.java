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

        Node res = search(root, 22);
        if(res == null)
            System.out.println("\n22 cannot be found in the BST");
        else
            System.out.println("\n22 is found in the node " + res);
    
        root = deleteNode(root, 22);
        System.out.println("After deleting the node 22 BST : ");
        printInorder(root);

    }

    static Node deleteNode(Node node, int key)
    {
        if(node == null)
        {
            System.out.println("Node not found");
            return null;
        }
        if(node.data > key)
            node.left = deleteNode(node.left, key);
        else if(node.data < key)
            node.right = deleteNode(node.right, key);
        else
        {
            //node is found
            Node temp;
            if(node.left == null &&  node.right == null)    //node with no child
                return null;
            else if(node.left == null)                      //node with 1 child
                return node.right;
            else if(node.right == null)                     //node with 1 child
                return node.left;
        
            //node with 2 childs    
            temp = minValueNode(node.right);            //inorder successor is taken here
            node.data = temp.data;
            node.right = deleteNode(node.right, node.data);
        }
        return node;
    }
    static Node minValueNode(Node node)
    {
        if(node.left == null)
            return node;
        return minValueNode(node.left);
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
    static Node search(Node node, int key)
    {
        if(node == null || node.data == key)
            return node;
        if(node.data > key)
            return search(node.left, key);
        
        return search(node.right, key);
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