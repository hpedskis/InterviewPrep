package BasicReview;

public  class isRotatedArray {
	//tested with multiple edge cases and convinced that this is a good algorithm!

	public static boolean isRotated(int[] A, int[] B){
		int AIndex =0;
		int BIndex =0;
		while(AIndex <= A.length -1 && BIndex <= B.length-1){
			System.out.println("entering while loop with A index " + AIndex + " and B index " + BIndex);
			if(A[AIndex] == B[BIndex]){
				AIndex++;
				BIndex++;
			}else{
				AIndex++;
			}
			if(AIndex == A.length -1 && BIndex == B.length-1){ //handles case of arrays being equal
				return false;
			}
		}
		
		
		int newAIndex =0;
		while(BIndex <= B.length-1){
			System.out.println("entering SECOND loop with BIndex " +BIndex); 
			if(B[BIndex] != A[newAIndex]){
				return false;
			}
			newAIndex++;
			BIndex++;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] A = {4,5,6,7,8,9,1,2,3};
		int[]B = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(isRotated(A,B));

	}

}
