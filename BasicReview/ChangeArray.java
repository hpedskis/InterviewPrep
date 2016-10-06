package BasicReview;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeArray {
	ArrayList<Integer> CoinType;
	ArrayList<Integer> ChangeArray = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));
	
	ChangeArray(){
		CoinType = new ArrayList<Integer>();
		CoinType.add(0, 25);
		CoinType.add(1, 10);
		CoinType.add(2, 5);
		CoinType.add(3, 1);
	}
	
	public void GetChange(int Change){
		for (int i =0; i < CoinType.size(); i++){
			int currentCoin = Math.round(Change / CoinType.get(i));
			if (currentCoin != 0){
				ChangeArray.set(i, currentCoin);
			}
			Change = Change % CoinType.get(i);
		}
	}
	public void PrintCoins(){
		for(int i: CoinType){
			System.out.print("" + i + " ");
		}
	}
	
	public void PrintChange(){
		for(int i: ChangeArray){
			System.out.print("" + i + " ");
		}
	}
	
	public static void main (String[] args){
		ChangeArray test = new ChangeArray();
		test.PrintCoins();
		test.GetChange(17);
		test.PrintChange();
	}
}


