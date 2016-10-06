package chapter8;

import java.util.ArrayList;

public class addParenth {
	//to find all ways to validly place parentheses, pass in the number of remaining open and close
	//build a string (using a character array) and add open first and then close
	//if one has run out, it's invalid, so stop
	//if both are at 0, that's the base case
	//each time you make a call, decrament the amount of left or right parenth, respectivley 
	public ArrayList<String> addParenthHelper(int n){
		ArrayList<String> list = new ArrayList<String>();
		char[] str = new char[n*2];
		calculateParenth(list, n, n, 0, str);
		return list;
		
	}
	
	public void calculateParenth(ArrayList<String> list, int numRight, int numLeft, int index, char[] str){
		if (numLeft < 0 || numRight < numLeft ){ //if you're out of open parenths, or if closed are less than open... invalid
			return;
		}
		if(numRight ==0 && numLeft == 0){
			//list.add(String.copyValueOf(str));
			String newString = new String(str);
			list.add(newString);
		}else{
			str[index] = '(';
			calculateParenth(list, numRight, numLeft -1, index+1, str);
			
			str[index] = ')';
			calculateParenth(list, numRight-1, numLeft, index+1, str);
		}
		
	}
	
	

	public static void main(String[] args) {
		addParenth test = new addParenth();
		System.out.println(test.addParenthHelper(3));
		

	}

}
