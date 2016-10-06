package BasicReview;

public class allSorts {
	int[] A;
	int[] newArray;
	
	void sort(int[]A) {
		newArray = new int[A.length];
		this.A = A;
		mergeSort(0, A.length -1);
	}

	void selectionSort(){
		
	}
	void insertionSort(){
		
	}
	void quickSort(){
		
	}
	 void mergeSort( int start, int end){
		int mid;
		if(start< end){
			mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			mergeSorted(start, mid, end);
		}
		
	}
	 void mergeSorted(int start,int mid, int end){
		int newIndex = 0;
		int leftIndex = start;
		int leftEnd = mid;
		int rightIndex = mid+1;
		int rightEnd = end;
		
		while((leftIndex <= leftEnd) && (rightIndex <= rightEnd)){
			if(A[leftIndex] <= A[rightIndex]){
				newArray[newIndex++] = A[leftIndex++];
			}else{
				newArray[newIndex++] = A[rightIndex++];
			}
		}
		while(leftIndex <= leftEnd){
			newArray[newIndex++] = A[leftIndex++];
		}
		while(rightIndex <= rightEnd){
			newArray[newIndex++] = A[rightIndex++];
		}
		
	}
	 void printArray(){
		for(int i=0; i< newArray.length;i++){
			System.out.print(newArray[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] A = {9,8,7,5,3,1};
		allSorts testMerge = new allSorts();
		testMerge.sort(A);
		testMerge.printArray();
		
		
		

	}

}
