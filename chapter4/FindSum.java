package chapter4;

import java.util.HashMap;

public class FindSum {


}

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
	 int calculateSum(Node node, int goalSum, int currentSum, HashMap<Integer, Integer> count){
		 if (node == null){
			 return 0;
		 }
		 currentSum += node.data;
		 int newSum = currentSum - goalSum;
		 int totalPaths = count.getOrDefault(newSum, 0);
		 if(currentSum == goalSum){
			 totalPaths++;
		 }
		 updateHashMap(count, currentSum);
		 totalPaths += calculateSum(node.left, goalSum, currentSum,count);
		 totalPaths += calculateSum(node.right, goalSum, currentSum, count);
		 return totalPaths;
			
		}
	 void updateHashMap(HashMap<Integer, Integer> count, int key){
		 int currentCount = count.getOrDefault(key, 0) + 1; //look for the current sum and add one
		 if (currentCount != 0){
			 count.put(key, currentCount);
		 }
	 }
	 
	 
	 public void printSums(Node n, int currentSum, HashMap<Integer, Integer> paths) {
	     if (n == null) {
	         return;
	     }
	     int newSum = currentSum + n.data;
	     incramentHashMap(paths, newSum); //add path for current node passed in
	    printSums(n.left, newSum, paths);
	    printSums(n.right, newSum, paths);
	    printSums(n.left, 0, paths);
	    printSums(n.right, 0, paths);
	} 
	 
	 void incramentHashMap(HashMap<Integer, Integer> paths, int sum){
		 int currentCount = paths.getOrDefault(sum, 0);
		 paths.put(sum, currentCount + 1);
	 }
	 

	 
	 




	 /* Driver program to test above functions */
	 public static void main(String[] args) {
	     BinaryTree tree = new BinaryTree();
	     tree.root = new Node(26);
	     tree.root.left = new Node(10);
	     tree.root.right = new Node(3);
	     tree.root.left.left = new Node(4);
	     tree.root.left.right = new Node(6);
	     tree.root.right.right = new Node(7);
	     tree.root.right.left = new Node(7);

	   int count = tree.calculateSum(tree.root, 12, 0, new HashMap<Integer, Integer>());
	   HashMap<Integer, Integer> testSums = new HashMap<Integer, Integer>();
	   tree.printSums(tree.root, 0, testSums);
	   System.out.println(count);
	   System.out.println(testSums.getOrDefault(12, -1));
	 }
}

