package Chapter1;

/*/
 * there are all the spcaes at the end of the string that are necessary.
 * I'd create a copy of the string without the spaces
 * create a new array of the size of the PASSED IN ARRAY (with extra room)
 * go through array without spaces backwards
 * if you hit a spce, add 0, 2, %
 * BAM
 * 
 */
public class URLify {
	
	public URLify(){
	}
	
	
	static String URLIfyInPlace(String s){
		char[] withSpaces = s.toCharArray();
		String trimmed = s.trim();
		int indexInArray = withSpaces.length -1;
		for (int i = trimmed.length() - 1; i > 0; i--){
			if(trimmed.charAt(i) == ' '){
				System.out.println("found a space at " + i);
				withSpaces[indexInArray--] = '0';
				withSpaces[indexInArray--] = '2';
				withSpaces[indexInArray--] = '%';
			}else{
				withSpaces[indexInArray--] = trimmed.charAt(i);
			}
		}
		return new String(withSpaces);
	}
	
	static String URLIfy(String s){
		StringBuilder sb = new StringBuilder(s.length());
		char[] CharS = s.trim().toCharArray(); //remove spaces
		for(int i = 0; i < CharS.length; i++){
			if (CharS[i] == (' ')){
				sb.append('%');
				sb.append('2');
				sb.append('0');
			}
			else{
				sb.append(CharS[i]);
			}
			
		}
		return sb.toString();
	}
	static int bla(int n){
		if (n ==1){
			return 1;
		}
		else{
			return 2* bla(n/3);
		}
	}

public static  void main(String[] args){
	String s = URLIfy("testing testing one two            ");
	String s2 = URLIfyInPlace("testing testing one two      ");
	System.out.println(s);
	System.out.println("new method " + s2);
	System.out.println(bla(27));
	
}
}