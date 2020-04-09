import java.util.*;

class Main
{
    public static void main(String[] args) {
        String input = "50 40 60 30 45 80 20 43 47 75 100 74 77 90 120 73 91 92 93";
        Scanner sc = new Scanner(input);
        int n = 19;
        Node root = null;

        //Creating the tree
        for(int i = 0; i < 19; i++)
        {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        
        getTopView(root);
    }

    public static void getTopView(Node root)
    {
        if(root == null)
            return;
        Queue <abc> q = new LinkedList<abc>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // dist = 0;
        q.add(new abc(root, 0));
        while(q.size() != 0)
        {
            abc obj = q.poll();
            if(!hm.containsKey(obj.dist))
                hm.put(obj.dist, obj.x.data);
            if(obj.x.left != null)
                q.add( new abc(obj.x.left, obj.dist-1)  );
            if(obj.x.right != null)
                q.add( new abc(obj.x.left, obj.dist-1));
        }
        for(int x: hm.keySet())
        {
            System.out.print(hm.get(x) + "-");
        }
    }


    public static Node insert(Node root, int data)
    {
        if(root == null)
            return new Node(data);
        if(root.data > data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }
}
class Node
{
    int data;
    Node left;
    Node right;
    Node(int d)
    {
        data = d;
    }
}

class abc
{
    Node x;
    int dist;       //distance
    abc(Node n, int d)
    {
        x = n;
        dist = d;
    }
}