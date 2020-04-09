import java.util.*;
class Main
{
	public static void main(String[] args) {
		Node root = null;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.print("Inorder Traversal ");
		Inorder(root);
		System.out.println();
		System.out.print("Preorder Traversal ");
		Preorder(root);
		System.out.println();
		System.out.print("Postorder Traversal ");
		Postorder(root);
		System.out.println();
		System.out.print("Postorder Using One Stack\n");
		PostOrderUsingOneStack(root);
		System.out.println();
		System.out.print("Level Order\n");
		LevelOrder(root);

	}
	public static void Inorder(Node root)
	{
		if(root != null)
		{
			Inorder(root.left);
			System.out.print(root.data + " ");
			Inorder(root.right);
		}
	}
	public static void Preorder(Node root)
	{
		if(root != null)
		{
			System.out.print(root.data + " ");
			Preorder(root.left);
			Preorder(root.right);
		}
	}
	public static void Postorder(Node root)
	{
		if(root != null)
		{
			Postorder(root.left);
			Postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	public static void LevelOrder(Node root)
	{
		Queue <Node>q = new LinkedList<Node>();
		q.add(root);
		Node curr = q.peek();
		while(q.size() != 0)
		{
			curr = q.poll();
			System.out.print(curr.data + " ");
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
			curr = q.peek();
		}
	}
	



	public static void PostOrderUsingOneStack(Node root)
	{
		Node curr = root;
		Node temp = null;
		Stack <Node> mystack = new Stack<Node>();
		while(curr != null || !mystack.isEmpty())
		{
			if(curr != null)
			{
				mystack.push(curr);
				curr = curr.left;
			}
			else
			{
				temp = mystack.peek();
				if(temp.right == null)
				{
					System.out.print(temp.data + " ");
					mystack.pop();
				}
				while(!mystack.isEmpty() && temp == (mystack.peek()).right)
				{
					temp = mystack.pop();
					System.out.print(temp.data + " ");
				}
				if(!mystack.isEmpty())
				{
					curr = mystack.peek().right;
				}
				else
				{
					curr = null;
				}

			}


		}
	}
	// public static void LevelOrder(Node root)
	// {
	// 	Queue<Integer>q = new LinkedList<Integer>();
		
	// }
}
class Node
{
	int data;
	Node left;
	Node right;
	Node(){}
	Node(int d){
		data = d;
	}
}