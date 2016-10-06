package Chapter7;

import java.util.Random;


/* NxN grid with B bombs
 * each cell has either a 0,1, or 2 depending on the proximity of bombs
 * If a number is uncovered, the number is exposed
 * If a bomb is uncovered, game over
 * If a black is uncovered, the adjacent blank cells up to the number cells, are uncovered
 * Optional "flags" can be placed in any cell that the user thinks is a bomb
 * 
 */
public class MineSweeper {
	

}
class Board{
	final int NUM_COLS = 7;
	final int NUM_ROWS = 7;
	int numBombs;
	int numberUnexposed;
	Cell[][] cells;
	Cell[] bombs;
	
	public Board(int numBombs){
		this.numBombs = numBombs;
		cells = new Cell[7][7];
		bombs = new Cell[numBombs];
		setUpBoard();
		
	}
	
	public void setUpBoard(){
		for (int i =0; i < NUM_COLS; i++ ){
			for (int j=0; j<NUM_ROWS; j++){
				cells[i][j].col = i;
				cells[i][j].row = j;
			}
		}
		selectBombs(); //after each cell has a place, select bombs
	}
	
	public void selectBombs(){
		Random rand = new Random();
		for (int i=0; i< numBombs; i++){ //for the amount of bombs, select a random cell
			boolean alreadyBomb = true;
			while(alreadyBomb){
				int randRow = rand.nextInt(NUM_ROWS);
				int randCol = rand.nextInt(NUM_COLS);
				if(cells[randCol][randRow].IsBomb == false){
					cells[randCol][randRow].IsBomb = true;
					bombs[i] = cells[randCol][randRow];
					alreadyBomb = false;
				}
			}
		}
		setUpNumbers();
	}

	public void setUpNumbers() {
		for (int i = 0; i < bombs.length; i++) {
			Cell c = bombs[i];
			getSquareUL(c);
			getSquareUM(c);
			getSquareUR(c);
			getSquareL(c);
			getSquareR(c);
			getSquareLL(c);
			getSquareLM(c);
			getSquareLR(c);
		}
		
	}
	public void Incrament(Cell c){
		c.number += 1;
	}
	
	public void getSquareUL(Cell bomb){
		int Row = bomb.row - 1;
		int Col = bomb.col - 1;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}			
		
	}
	public void getSquareUM(Cell bomb){
		int Row = bomb.row - 1;
		int Col = bomb.col;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}
		
	}
	public void getSquareUR(Cell bomb){
		int Row = bomb.row + 1;
		int Col = bomb.col + 1;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}
		
	}
	public void getSquareL(Cell bomb){
		int Row = bomb.row;
		int Col = bomb.col - 1;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}
	
	}
	public void getSquareR(Cell bomb){
		int Row = bomb.row;
		int Col = bomb.col + 1;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}
		
	}
	public void getSquareLL(Cell bomb){
		int Row = bomb.row + 1;
		int Col = bomb.col - 1;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}
		
	}
	public void getSquareLM(Cell bomb){
		int Row = bomb.row + 1;
		int Col = bomb.col;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}
		
	}
	public void getSquareLR(Cell bomb){
		int Row = bomb.row + 1;
		int Col = bomb.col + 1;
		
		if ((Row < 0 || Row >= NUM_ROWS) || (Col >= NUM_COLS || Col < 0)){
			return;	
		}
		else{
			Incrament(cells[Col][Row]);
		}
	
	}
	
}

class Cell{
	int col;
	int row;
	int number =0; //initial
	boolean IsBomb = false;
	boolean IsFlagged = false;
	boolean IsExposed = false;
	
	public Cell (int col, int row){
		this.row = row;
		this.col = col;
	}
	
	public boolean FlipCoin(){
		IsExposed = true;
		if(IsBomb == true){
			return false; //end of game
		}
		return true; //continue playing
	}
	
}
