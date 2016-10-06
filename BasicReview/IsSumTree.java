package BasicReview;

import chapter4.Node;


class Node {
 int data;
 Node left;
 Node right;

 Node(int item) {
     data = item;
     left = right = null;
 }
}

class BinaryTree {
 Node root;


 int sum(Node n){
	 if (n == null){
		 return 0;
	 }
	 return (sum(n.right) + sum(n.left) + n.data);
 }
 
 boolean isSumTree(Node node) {
	 int leftSum, rightSum;
	 
	 if (node == null || (node.left == null && node.right == null)){
		 return true; 
	 }
	 
	 leftSum = sum(node.left);
	 rightSum = sum (node.right);
	 
	 if (leftSum + rightSum == node.data && (isSumTree(node.left) != false && isSumTree(node.right) != false)){
		 return true;
	 }
	 return false;
	 
     
 }

 /* Driver program to test above functions */
 public static void notmain(String args[]) {
     BinaryTree tree = new BinaryTree();
     tree.root = new Node(26);
     tree.root.left = new Node(10);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(6);
     tree.root.right.right = new Node(3);

     if (tree.isSumTree(tree.root) != false)
         System.out.println("The given tree is a sum tree");
     else
         System.out.println("The given tree is not a sum tree");
 }
}



