package Chapter1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class oneAway {
	boolean OneAway(String s1, String s2){
		if (s1.length() == s2.length()){
			return replacedCheck(s1, s2);
		} else if(s1.length() + 1 == s2.length() || s1.length() -1 == s2.length()){
			return insertCheck(s1, s2);
		}
		return false;
	}
	boolean replacedCheck(String s1, String s2){
		boolean foundChange = false;
		for(int i=0; i< s1.length(); i++){
			if (s1.charAt(i) != s2.charAt(i)){
				if(foundChange){
					return false;
				}
				foundChange = true;
			}
		}
		return true;
	}
	
	boolean insertCheck(String s1, String s2){
		int index1 = 0;
		int index2 = 0;
		while(index1<s1.length() && index2<s2.length()){
			if (s1.charAt(index1) != s2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index1++;
			}
			else{
				index1++;
				index2++;
			}
		}
		return true;
		
	}
	

	
	public static void main(String[] args){
		oneAway test = new oneAway();
		System.out.println(test.OneAway("pale", "ple")); //should be true
		System.out.println(test.OneAway("pale", "bae")); //should be false
		System.out.println(test.OneAway("pales", "pale")); //should be true
		System.out.println(test.OneAway("pale", "bale")); //should be true
		
	}

}
