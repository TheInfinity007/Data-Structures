class AVLTree
{
    Node root;

    int height(Node node)
    {
        if(node == null)
            return 0;
        return node.height;
    }
        
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    int getBalance(Node node)
    {
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
    
    Node leftRotate(Node x)
    {
        Node y = x.right;
        x.right = y.left;
        y.left = x;

        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    Node rightRotate(Node x)
    {
        Node y = x.left;
        x.left = y.right;
        y.right = x;

        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }
    
    Node insert(Node node, int key)
    {
        if(node == null)
            return new Node(key);
        if(node.key > key)
            node.left = insert(node.left, key);
        else if(node.key < key)
            node.right = insert(node.right, key);
        else
            return node;    //we don't need duplicate element
        
        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        //RIGHT RIGHT CASE
        if(balance < -1 && key > node.right.key)
        {
            return leftRotate(node);
        }

        //RIGHT LEFT CASE
        if(balance < -1 && key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        //LEFT LEFT CASE
        if(balance > 1 && key < node.left.key)
            return rightRotate(node);
        
        //LEFT RIGHT CASE
        if(balance > 1 && key > node.left.key)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        return node;
    }    

    Node minValueNode(Node node)
    {
        Node current = node;
        while(current.left != null)
            current = current.left;
        return current;
    }

    Node deleteNode(Node node, int key)
    {
        if(node == null)
            return node;
        if(node.key > key)
            node.left = deleteNode(node.left, key);
        else if(node.key < key)
            node.right = deleteNode(node.right, key);
        else
        {
            if(node.left == null && node.right == null)
                node = null;
            else if(node.left == null)
                node = node.right;
            else if(node.right == null)
                node = node.left;
            else
            {
                Node temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = deleteNode(node.right, temp.key);
            }
        }

        if(node == null)
            return node;
        
        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        //LEFT LEFT CASE
        if(balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        
        //LEFT RIGHT CASE
        if(balance > 1 && getBalance(node.left) < 0)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        //RIGHT RIGHT CASE
        if(balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);
        
        //RIGHT LEFT CASE
        if(balance < -1 && getBalance(node.right) > 0)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        // tree.root = tree.insert(tree.root, 10);
        // tree.root = tree.insert(tree.root, 20);
        // tree.root = tree.insert(tree.root, 30);
        // tree.root = tree.insert(tree.root, 40);
        // tree.root = tree.insert(tree.root, 50);
        // tree.root = tree.insert(tree.root, 25);

        tree.root = tree.insert(null, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        System.out.println("Printing the tree in inorder traversal");
        printInorder(tree.root);

        tree.root = tree.deleteNode(tree.root, 10);
        System.out.println("Printing the tree in inorder traversal after deleting 10");
        printInorder(tree.root);
    }

    static void printInorder(Node node)
    {
        if(node != null)
        {
            printInorder(node.left);
            System.out.print(node.key + " ");
            printInorder(node.right);
        }
    }

}
class Node
{
    int key, height;
    Node left, right;
    Node(int data)
    {
        key = data;
        height = 1;
    }
}