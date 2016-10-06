package chapter10;

public class matrixSearch {
	int[][] sortedMatrix;
	Coordinate currentDiag;
	int key;
	int rowEnd;
	int colEnd;
	
	matrixSearch(int[][]matrix) throws Exception{
		if(matrix[0] == null || matrix[0].length == 0){
			throw new Exception("must enter valid matrix");
		}
		sortedMatrix = matrix;
		rowEnd = matrix.length - 1;
		colEnd = matrix[0].length - 1;
		
	}
	//returns a coordinate with the coordinate of the key, or -1. -1
	Coordinate findInMatrix(int[][]matrix, Coordinate currentDiag, int key){
		if((currentDiag.row == -1 && currentDiag.col == -1) || matrix[currentDiag.row][currentDiag.col] == -1) {
			return new Coordinate (-1, -1);
		}
		int DiagValue = matrix[currentDiag.row][currentDiag.col];
		if(key < DiagValue && key < matrix[0][currentDiag.col]){ //if it's too smaller than the largest and smallest 
																//element in the column, move to the left
			currentDiag.changeDiag(); //shift to column to the left
			findInMatrix(matrix, currentDiag, key);
		}
		else if(key>DiagValue && key> matrix[rowEnd][currentDiag.col]){ //if it's larger than the largest element in the column
																	//we know it cannot exist in the matrix since we move largest to smallesr
			return new Coordinate(-1, -1);
		}
		else if (key < DiagValue && key > matrix[0][currentDiag.col]){ //should be somewhere between top and diag
			Coordinate found = searchFromDiagToTop(matrix, currentDiag, key);
			if (found.row != -1 && found.col != -1){
				return found;
			}
			else{ //possible to be in column to the left
				currentDiag.changeDiag();
				findInMatrix(matrix, currentDiag, key);
			}
		}
		else{
			Coordinate found = searchFromDiagToBottom(matrix, currentDiag, key);
			if (found.row != -1 && found.col != -1){
				return found;
			}
			else{ //possible to be in column to the left
				currentDiag.changeDiag();
				findInMatrix(matrix, currentDiag, key);
			}
		}
		return new Coordinate (-1, -1); //??
	}
	
	Coordinate searchFromDiagToTop(int[][] matrix, Coordinate currentDiag, int key){
		Coordinate copy = currentDiag; //copy of coordinates
		int value = matrix[copy.row][copy.col];
		while ((value != key) && (copy.row >= 0)){
			copy.row -= 1;
			value = matrix[copy.row][copy.col];
		}
		if(value == key){
			return new Coordinate(copy.row, copy.col);
		}
		return new Coordinate(-1, -1);
	}
	Coordinate searchFromDiagToBottom(int[][]matrix, Coordinate currentDiag, int key){
		Coordinate copy = currentDiag; //copy of coordinates
		int value = matrix[copy.row][copy.col];
		while ((value != key) && (copy.row <= rowEnd)){
			copy.row += 1;
			value = matrix[copy.row][copy.col];
		}
		if(value == key){
			return new Coordinate(copy.row, copy.col);
		}
		return new Coordinate(-1, -1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Coordinate{
		int row;
		int col;
		
		Coordinate(int r, int c){
			row = r;
			col = c;
		}
		
		void changeDiag(){
			row -= 1;
			col -= 1;
			
		}
	}

}
