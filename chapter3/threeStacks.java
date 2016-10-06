package chapter3;

import java.util.ArrayList;

public class threeStacks {
	int size;
	public int[] Stacks;
	public int firstStart; //where does the first stack start
	public int firstCurrent; //where is the last element in the first stack
	public int secondStart; //where does the second stack start
	public int secondCurrent; //where is the last element in second stack
	public int thirdStart; //where does the third stack start
	public int thirdCurrent; //where is the last element in the third stack
	
	public threeStacks(int size){
		Stacks = new int[size * 3];
		firstStart = 0;
		firstCurrent = firstStart;
		secondStart = size;
		secondCurrent = secondStart;
		thirdStart = size * 2;
		thirdCurrent = thirdStart;
	}
	
	public void CorrectStackCheck(int stack){
		if ((stack == 1) || (stack == 2) || (stack == 3)){
			
		}
		else{
			throw new IllegalArgumentException("must insert into stack 1, 2, or 3"); //must be one of the three stacks
		}
	}
	
	public void addToStack(int data, int stack){
		CorrectStackCheck(stack);
		if (IsStackFull(stack)){
			throw new IllegalStateException("stack " + stack + " is full.");
		}
		if (stack == 1){
			Stacks[firstCurrent] = data;
			firstCurrent++;
		}
		if(stack == 2){
			Stacks[secondCurrent] = data;
			secondCurrent++;
		}
		if(stack == 3){
			Stacks[thirdCurrent] = data;
			thirdCurrent++;
		}
	}
	
	public void removeFromStack (int stack){
		CorrectStackCheck(stack);
		if (stack == 1){
			removeFirstStack();	
		}
		if(stack == 2){
			removeSecondStack();
		}
		else{
			removeThirdStack();
		}
	}
	
	public boolean removeFirstStack(){
		if (firstCurrent == firstStart){
			System.out.println("first stack is empty");
			return false;
		}
		int data = Stacks[--firstCurrent];
		System.out.println(data);
		return true;
	}
	public boolean removeSecondStack(){
		if (secondCurrent == secondStart){
			System.out.println("second stack is empty");
			return false;
		}
		int data = Stacks[--secondCurrent];
		System.out.println(data);
		return true;
	}
	public boolean removeThirdStack(){
		if (thirdCurrent == thirdStart){
			System.out.println("third stack is empty");
			return false;
		}
		int data = Stacks[--thirdCurrent];
		System.out.println(data);
		return true;
	}
	
	public boolean IsStackFull(int stack){
		if (stack == 1){
			if (firstCurrent == secondStart - 1){
				return true;
			}
			return false;
		}
		else if (stack == 2){
			if (secondCurrent == thirdStart - 1){
				return true;
			}
			return false;
		}
		else{
			if (thirdCurrent == size - 1){
				return true;
			}
			return false;
		}
	}
	
	public static void main (String[] args){
		threeStacks theStacks = new threeStacks(10);
		System.out.println("start for each stack (1)" + theStacks.firstStart + " (2) " + theStacks.secondStart + " (3) " + theStacks.thirdStart);
		theStacks.addToStack(1, 1);
		System.out.println(theStacks.firstCurrent);
		theStacks.addToStack(2, 2);
		theStacks.addToStack(3, 3);
		
		theStacks.removeFromStack(2);
	}

}
