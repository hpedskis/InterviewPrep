package BasicReview;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class evaluateNumber {
	public evaluateNumber(){
		
	}

	public TreeNode parseInputToTree(String s){
		  StringTokenizer st = new StringTokenizer(s);
		  String firstArg = st.nextToken();
	      boolean Isprimitive = isPrimitive(firstArg);
	        if (Isprimitive){
	          return getNumberNode(firstArg);
	        }
	      //CheckFirstChar(firstArg);
	      //supportedOperator(firstArg);
	      
	      String left = getStringThatShouldBeTheNextChild(st); // "( + 4 2 )"    ( + ( * 2 5) 2 )
	      String right = getStringThatShouldBeTheNextChild(st); // "( + 1 1 )" 
	      
		   return  new TreeNode(firstArg, parseInputToTree(left), parseInputToTree(right)); 
		}
	  
	  public String getStringThatShouldBeTheNextChild (StringTokenizer s){
	  	String result = s.nextToken() + " ";
	  	int parenthCount = 1;
	    while(parenthCount != 0){
	    	String temp = s.nextToken();
	      result+= temp + " ";
	      if (temp == "("){
	        parenthCount++;
	      }
	      else if (temp == ")"){
	      	parenthCount--;
	    	}
	    }
	    return result;
	  }
	    
	 public TreeNode getNumberNode(String s){
	  	int NodeNumber = Integer.parseInt(s);
	  	TreeNode newNode = new TreeNode(NodeNumber);

	    return newNode;
	    }
	  
	  
	  boolean isPrimitive(String s){
		  for (char c : s.toCharArray())
		    {
		        if (!Character.isDigit(c)) return false;
		    }
		    return true;
	  }
	  
	  public void CheckFirstChar(String s){
	  	if (!(s.equals("("))){
	    	throw new RuntimeException("expression must start with open parenth");
	      }
	    }
	  
	   int gatherNumbers(TreeNode node){
		   	//traverse to the bottom
		    //when children are null, take current and return to parent
		    //if parent is + or *, "process" 
		    if (node.isPrimitive){
		    	return node.data;
		    }
		    int left = gatherNumbers(node.leftchild);
		    int right = gatherNumbers(node.rightchild);
		    //expression 
		   	if (node.expression.equals("+")){
		    	return left + right;
		    }
		    else{
		    	return left * right;
		    }
		}
	  
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner input = new Scanner(System.in);
			//tell user to put in a number
			System.out.println("Please enter a pre order string to see the solution");
			System.out.println("An example is (* (+ 4 2) (+ 1 1))");
			System.out.print("> ");
			//variable n is equal to input number
			String s = input.next();
			evaluateNumber test = new evaluateNumber();
			TreeNode result = test.parseInputToTree(s);
		    int GatheringResults = test.gatherNumbers(result);
		    System.out.println(GatheringResults);
			
			   
		}
		
		public class TreeNode{
	  	TreeNode leftchild;
	    TreeNode rightchild;
	    boolean isPrimitive;
	    int data;
	    String expression;
	    boolean isExpression;
	    
	    public TreeNode(int data){
	    	this.data = data;
	      isExpression = false;
	      isPrimitive = true;
	    }
	    public TreeNode(String expression, TreeNode l, TreeNode r){
	   	 leftchild = l;
	   	 rightchild = r;
	    	this.expression = expression;
	      isExpression = true;
	      isPrimitive = false;
	      
	    }
	  
	  }
	

}
