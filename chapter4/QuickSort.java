package chapter4;

import java.util.Arrays;

public class QuickSort {
	private static int[] theArray;
	private static int arraySize;
	
	
	public static void main (String[] args){
		QuickSort theSort = new QuickSort(10);
		theSort.generateRandomArray();
		System.out.println(Arrays.toString(QuickSort.theArray));
		theSort.quickSort(0,9);
		System.out.println(Arrays.toString(QuickSort.theArray));
	}
	
	QuickSort(int size){
		arraySize = size;
		theArray = new int[arraySize];
		generateRandomArray();
	}
	
	public void quickSort(int left, int right){
		if (right - left <= 0){ //everything is sorted
			return;
		}else{
			int pivot = theArray[right]; //can be anything in the array
			System.out.println("Value in right " + theArray[right]
	
					                    + " is made the pivot");
					
		 System.out.println("left = " + left + " right= " + right
					
					                    + " pivot= " + pivot + " sent to be partitioned");
		 int pivotLocation = partitionArray(left, right, pivot);
		 System.out.println("Value in left " + theArray[left] + " is made the pivot");
		 quickSort(left, pivotLocation -1);
		 quickSort(pivotLocation +1, right);
		}
	}
		
		public int partitionArray(int left, int right, int pivot){
			int leftPointer = left -1;
			int rightPointer = right;
			while(true){
				while(theArray[++leftPointer] < pivot){
					; //or nothing??
				}
				printHorzArray(leftPointer, rightPointer);
				System.out.println(theArray[leftPointer] + " in index " + leftPointer + " is bigger than the pivot value " + pivot);
				
				while(rightPointer > 0 && theArray[--rightPointer] > pivot){
					;
				}
				printHorzArray(leftPointer, rightPointer);
				System.out.println(theArray[rightPointer] + " in index " + rightPointer + " is smaller than the pivot value " + pivot);
				printHorzArray(leftPointer, rightPointer);
				
				if (leftPointer>= rightPointer){
					System.out.println("left is larger or equal to right so start again");
					break;
				} else{
					swapValues(leftPointer, rightPointer);
					System.out.println(theArray[leftPointer] + " was swapped for " + theArray[rightPointer]);
					break;
				}
		}
			
			swapValues(leftPointer, right);
			return leftPointer;
	}
		
		public void swapValues(int indexOne, int indexTwo){
			int temp = theArray[indexOne];
			theArray[indexOne] = theArray[indexTwo];
			theArray[indexTwo] = temp;
		}
		
		public void generateRandomArray(){
			for (int i=0; i< arraySize; i++){
				theArray[i] = (int)(Math.random() * 50) + 10;
			}
		}
		

	static void printHorzArray(int i, int j) {

		for (int n = 0; n < 61; n++) {
			System.out.print("-");

		}
		System.out.println();
		for (int n = 0; n < arraySize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++) {

			System.out.print("-");
		}

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print(String.format("| %2s " + " ", theArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++) {

			System.out.print("-");
		}

		System.out.println();

		if (i != -1) {
			int spacesBeforeFront = 6 * (i + 1) - 5;

			for (int k = 0; k < spacesBeforeFront; k++) {

				System.out.print(" ");
			}
			System.out.print("L" + i);

			int spacesBeforeRear = 5 * (j + 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++) {
				System.out.print(" ");
			}

			System.out.print("R" + j);

			System.out.println("\n");

		}

	}	

}
