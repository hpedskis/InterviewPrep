package chapter4;

import java.util.Stack;


//to find a path, go through depth first search
//need one method to search, one method to find unvisited
//two booleans inside search method. if both were seen, return true
public class FindPath {
	int size;
	Node[] nodeList;
	int[][] graphOfNodes;
	
	FindPath(Node[] nodeList){ //constructor
		this.size = nodeList.length -1;
		this.nodeList = nodeList;
		graphOfNodes = new int[size][size];
		for(int i=0; i< size +1; i++){
			for(int j =0; j< size+1; j++){
				graphOfNodes[i][j] = -1;
			}
		}
		
	}
	
	boolean findPath(Node n1, Node n2){
		boolean seenN1 = false;
		boolean seenN2 = false;
		
		Stack<Node> theStack = new Stack<Node>();
		theStack.push(nodeList[0]);
		nodeList[0].wasVisited = true;
		if(nodeList[0].name == n1.name){
			seenN1 = true;
		} else if(nodeList[0].name == n2.name){
			seenN2 = true;
		}
		while(!(theStack.isEmpty()) || !(seenN1 && seenN2)){
			Node nextNode = findUnvisited(theStack.peek());
			if(nextNode == null){
				theStack.pop();
			}
			else{
				theStack.push(nextNode);
				nextNode.wasVisited = true;
				if(nodeList[0].name == n1.name){
					seenN1 = true;
				} else if(nodeList[0].name == n2.name){
					seenN2 = true;
				}
			}
		}
		return (seenN1 && seenN2);
	}
	
	Node findUnvisited(Node n){ //go through graph and see what node's n is connected to
		int nRow = -1;
		for(int i=0; i< nodeList.length; i++){
			if (nodeList[i].name == n.name){
				nRow = i;
			}
		}
		for (int i =0; i < size; i++){
			if (graphOfNodes[nRow][i] == 1 && nodeList[i].wasVisited == false){
				return nodeList[i];
			}
		}
		return null;
	}
	
	
	class Node{
		char name;
		boolean wasVisited;
		
		Node(char c){
			name = c;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

