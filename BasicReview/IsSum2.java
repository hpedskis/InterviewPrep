package BasicReview;

class Node2{
	int data;
	Node2 left;
	Node2 right;
	
	Node2(int data){
		this.data = data;
		left = right = null;
	}
}
class BinaryTree2 {
	Node2 root; 
	
	int sum(Node2 n){ //assuming this works
		if (n == null){
			return 0;
		}
		
		return (sum(n.left) + n.data + sum(n.right));
	}
	
	boolean isSumTree (Node2 n){
		int leftSum;
		int rightSum;
		
		if (n == null || (n.left == null && n.right == null)){ //if empty or leaf
			return true; 
		}
		
		leftSum = sum(n.left);
		rightSum = sum(n.right);
		
		if(leftSum + rightSum == n.data && (isSumTree(n.left) != false && isSumTree(n.right) != false)){
			return true; 
		}
		return false;
		
		
	}


public static void main (String args[]){
	BinaryTree2 tree = new BinaryTree2();
	tree.root = new Node2(26);
    tree.root.left = new Node2(10);
    tree.root.right = new Node2(3);
    tree.root.left.left = new Node2(4);
    tree.root.left.right = new Node2(6);
    tree.root.right.right = new Node2(3);
	
	if (tree.isSumTree(tree.root) != false){
		System.out.println("sum tree for sure");
	}
	else{
		System.out.println("NAH");
	}
}
}
