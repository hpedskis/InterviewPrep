package Chapter1;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
	
	boolean isUniqueChars(String str){
		long startTime = System.nanoTime();
		if (str.length() > 128){
			return false;
		}
		else{
			boolean[] char_set = new boolean[128];
			for (int i=0; i< str.length(); i++){
				int val = str.charAt(i);
				if(char_set[val] == true){
					return false;
				}
				char_set[val] = true;
			}
			long endTime = System.nanoTime();
			System.out.println("Took "+(endTime - startTime) + " ns");
			return true;
		}
		
	}
	
	boolean isUnique(String s){
		long startTime = System.nanoTime();
		if (s.length() > 128){
			return false;
		}
		Set<Character> seen = new HashSet<Character>();
		for (char c: s.toCharArray()){
			if(c == ' '){
				continue;
			}
			if (seen.contains(c)){
				return false;
			}
			else{
				seen.add(c);
			}
		}
		
		//code
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		return true;
	}


public static void main (String [] args){
	String s = "is this a string with unique";
	String s2 = "yes";
	
	IsUnique test = new IsUnique();
	System.out.println(test.isUniqueChars(s));
	System.out.println(test.isUniqueChars(s2));
	System.out.println(test.isUnique(s));
	System.out.println(test.isUnique(s2));
	
}
}


