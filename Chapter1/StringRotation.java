package Chapter1;

public class StringRotation {
	
	boolean isRotation(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		boolean secondPass = false;
		boolean foundDifference = false;
		char[] s1A = s1.toCharArray();
		char[] s2A = s2.toCharArray();
		
		int s1Index =0;
		int s2Index =0;
		
		while(s1Index < s1A.length){
			if(s1A[s1Index] != s2A[s2Index]){
				if (secondPass && foundDifference){
					return false;
				}
				foundDifference = true;
				s2Index++;
			}else{
			s1Index++;
			s2Index ++;
			}
			if(s2Index == s2A.length){
				secondPass = true;
				s2Index =0;
		}
		}
		if(foundDifference){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		StringRotation test = new StringRotation();
		boolean output = test.isRotation("can", "acc");
		System.out.println(output);

	}

}
