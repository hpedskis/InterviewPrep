package chapter4;

import java.util.Stack;

public class findAncestor {
	Stack<Node> N1Stack;
	Stack<Node> N2Stack;
	Tree tree;
	
	public findAncestor(){
		tree= new Tree();
		tree.createTree();
		N1Stack = new Stack<Node>();
		N2Stack = new Stack<Node>();
	}
	public Node findAncestorHelper(int n1, int n2){
		
		Node Node1 = new Node(n1);
		
		Node Node2 = new Node(n2);
		System.out.println("just created two new nodes with data " + Node1.data + " and " + Node2.data);
		Node ancestor = null;
		try {
			ancestor = findAncestors(Node1, Node2);
		} catch (Exception e) {
			System.out.println("something went wrong");
		}
		return ancestor;
	}
	
	public Node findAncestors(Node N1, Node N2) throws Exception{
		System.out.println("root is " + tree.root.data);
		if (!(createStacks(tree.root, N1, N1Stack))){
			throw new Exception("first passed in node didn't exist");
		}
		if (!(createStacks(tree.root, N2, N2Stack))){
			throw new Exception("second passed in node didn't exist");
		}
		if(N1Stack.size() > N2Stack.size()){ //N1 is further down in tree
			N1Stack = makeStacksEqual(N1Stack, N1Stack.size() - N2Stack.size());	
		}
		else if(N2Stack.size() > N1Stack.size()){
			N2Stack = makeStacksEqual(N2Stack, N2Stack.size() - N1Stack.size());	
		} //otherwise, stacks already equal 
		while(N1Stack.peek() != N2Stack.peek() && !(N1Stack.isEmpty() && N2Stack.isEmpty())){
			N1Stack.pop();
			N2Stack.pop();
		}
		if(N1Stack.peek() != N2Stack.peek()){
			throw new Exception("no match");
		}
       return N1Stack.peek();
		
		
	}
	public Stack<Node> makeStacksEqual(Stack<Node> deeperStack, int sizeDifference){
		for (int i=0; i< sizeDifference; i++){
			deeperStack.pop();
		}
		return deeperStack;
		
	}
	
	public boolean createStacks(Node root, Node N1, Stack<Node> stack){
		if(root == null){
			return false;
		}
		if(root.data == N1.data){
			stack.push(root);
			return true;
		}
		boolean checkLeft = createStacks(root.left, N1, stack);
		boolean checkRight = createStacks(root.right, N1, stack);
		if (checkLeft || checkRight){
			stack.push(root);
			return true;
		}
		return false;
		
		
	}
	public Node getUnvisited(Node n){
		if (n.left != null && n.left.wasVisited == false){
			return n.left;
		}
		else if (n.right != null && n.right.wasVisited == false){
			return n.right;
		}
		return null;
		
	}
	
	class Node{
		int data;
		Node left;
		Node right;
		boolean wasVisited = false;
		
		public Node(int data){
			this.data = data;
			left = right = null;
		}
	}

	class Tree{
		Node root;
		
		public Tree(){
			root = null;
		}
		
		public void createTree(){
			Node A = new Node(1);
			Node B = new Node(2);
			Node C = new Node(3);
			Node D = new Node (4);
			Node E = new Node(5);
			Node F = new Node (6);
			Node G = new Node(7);
			tree.root = A;
			A.left = B;
			A.right = C;
			B.left = D;
			B.right = E;
			C.left = F;
			C.right = G;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findAncestor test = new findAncestor();
		Node ancestor = test.findAncestorHelper(5, 4);
		System.out.println("ancestor is " + ancestor.data);

	}

}


