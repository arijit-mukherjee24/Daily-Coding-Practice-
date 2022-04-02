package com.dp.one.dimensional;

//Sahil : DP(2)
//TC:O(n)  SC:O(n)

// 198. House Robber
import java.util.HashMap;

public class House_Robber {

	public static void main(String[] args) {

	}
	
	public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return maxRobAmt(nums, 0, memo);
    }
    
    private int maxRobAmt(int[] nums, int currentIndex, HashMap<Integer,Integer> memo) {
        if(currentIndex >= nums.length)
            return 0;
        
        int currentKey = currentIndex;
        if(memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }
        
        int rob = nums[currentIndex] + maxRobAmt(nums, currentIndex+2, memo);
        int noRob = maxRobAmt(nums, currentIndex+1, memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return memo.get(currentKey);
    }

}
