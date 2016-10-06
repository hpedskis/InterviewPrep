package chapter8;

public class makeChange {
	int[] coins = {25, 10, 5, 1};
	int[][] memo;
	int amount;
	
	public makeChange(int n){
		amount = n;
		memo = new int[n + 1][coins.length];
	}
	int makeChangeHelper(){
		return makeChange(amount, coins, 0, memo);
	}
	
	int makeChange(int amount, int[]coins, int index, int[][]memo){
		if(index >= coins.length -1){
			System.out.println("hit base case with index " + index);
			return 1;
		}
		if(memo[amount][index] > 0){
			System.out.println(amount + " " + index + " already found in memo. returning " + memo[amount][index]);
			return memo[amount][index];
		}
		int ways = 0;
		int coinValue = coins[index];
		for(int i=0; i*coinValue <= amount; i++){
			System.out.println("entering for loop with coin " + coins[index] + " and amount " + amount);
			int newAmount = amount - i*coinValue;
			System.out.println("making recursive call with new amount "+ newAmount + " and index " + (index+1));
			ways += makeChange(newAmount, coins, index + 1, memo);
			
		}
		memo[amount][index] = ways;
		return ways;
	}

	public static void main(String[] args) {
		makeChange test = new makeChange(25);
		int ways = test.makeChangeHelper();
		System.out.println(ways);

	}

}
