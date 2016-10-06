package Chapter1;

/*/
 * to find if two strings are a permutation, the easiest way is to sort them and then compare 
 * them for equality. Initially, if they're different lengths, it can be assumed that they are not 
 * equal.
 * 
 * If spaces didn't count, you could also trim them for any whitespace before, using StringUtils
 */
public class IsPermutation {
	
	boolean IsPermutaiton(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		
		return(sort(s1).equals(sort(s2)));
	}
	
	String sort(String s){
		char[] charS = s.toCharArray();
		java.util.Arrays.sort(charS);
		return new String(charS); //returned newly sorted string
	}

}

