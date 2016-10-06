package BasicReview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class CounterfitDollar {
	int numTimesRunning;
	HashSet<Character> CoinsToTest;
	HashSet<Character> tested;
	HashSet<Character> RealCoins;
	String[] input;
	File data;
	Scanner scanner;
	boolean Lighter;
	boolean Heavier;
	
	public CounterfitDollar() throws FileNotFoundException{
		CoinsToTest = new HashSet<Character>();
		setUpCoins();
		tested = new HashSet<Character>();
		RealCoins = new HashSet<Character>();
		data = new File("/Users/hpedskis/Documents/Interview Prep/Interview_Prep/src/BasicReview/CoinTest.txt");
		scanner = new Scanner(data);
	}
	
	public void setUpCoins(){
		CoinsToTest.add('A');
		CoinsToTest.add('B');
		CoinsToTest.add('C');
		CoinsToTest.add('D');
		CoinsToTest.add('E');
		CoinsToTest.add('F');
		CoinsToTest.add('G');
		CoinsToTest.add('H');
		CoinsToTest.add('I');
		CoinsToTest.add('J');
		CoinsToTest.add('K');
		CoinsToTest.add('L');
	}
	public void FindFake(){
		numTimesRunning = Integer.parseInt(scanner.nextLine());
		for (int i=0; i< numTimesRunning; i++){
			for(int j=0; j<3; j++){ //three weighings per time running
				String[] split = splitFileLine(scanner.nextLine());
				if (split[2].equals("even")){
					splitAndDelete(split, RealCoins);	//remove from "to test"
				}
				else if(split[2].equals("up")){
					Lighter= true;
				}
				else{ //scale is down
					Heavier= true;
				}
			}
			System.out.println(CoinsToTest.size());
			RemoveUnSeen();
			System.out.println(CoinsToTest.iterator().next());
			
			if(Lighter){
				System.out.println("coin is lighter" );
			}
			else{
				System.out.println("coin is heavier" );
			}
			
		}
	}
	public String[] splitFileLine(String s){
		String[] fileLine = s.split(" ");
		return fileLine;
	}
	
	public void RemoveUnSeen(){
		System.out.println("inside remove");
		for(char c: CoinsToTest){
			if(!(tested.contains(c))){
				System.out.println("removed " + c);
				CoinsToTest.remove(c);
			}
		}
		
		//go through 
	}
	//TODO
	//make a method to split
	//make a method to delete separately
	//need to make it so even those returning up and down are marked as tested
	
	public void splitCorrect(String[]s){
		String unFixed1 = s[0]; //first section of coins
		String unFixed2 = s[1]; //second section of coins
		char[] Fixed1 = unFixed1.toCharArray();
		char[] Fixed2 = unFixed2.toCharArray();
		
	}
	
	public void splitAndDelete(String[] s, HashSet<Character> AddCoins){
		String unFixed1 = s[0]; //first section of coins
		String unFixed2 = s[1]; //second section of coins
		char[] Fixed1 = unFixed1.toCharArray();
		char[] Fixed2 = unFixed2.toCharArray();
		for(char c: Fixed1){
			AddCoins.add(c);
			tested.add(c);
			CoinsToTest.remove(c);
		}
		for(char c: Fixed2){
			AddCoins.add(c);
			tested.add(c);
			CoinsToTest.remove(c);
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		CounterfitDollar test = new CounterfitDollar();
		test.FindFake();
		
		
	
}

}
