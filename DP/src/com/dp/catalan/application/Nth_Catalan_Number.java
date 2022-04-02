package com.dp.catalan.application;

import java.math.BigInteger;
import java.util.HashMap;

// Nth catalan number - https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1

//Sahil DP (Day-10)
//TC:O(n^2)   SC:O(n)
//C(2) = 2 (Take recursion of C(2))
public class Nth_Catalan_Number {

	public static void main(String[] args) {

	}
	
	//Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        return nthCatalan(n, new HashMap<Integer, BigInteger>());
    }
    
    private static BigInteger nthCatalan(int n, HashMap<Integer, BigInteger> memo) {
        
        if(n==0 || n==1)
            return new BigInteger("1");
            
        int currentKey = n;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
            
        BigInteger ways = new BigInteger("0");
        
        for(int i=0; i<n; i++) {
            BigInteger a = nthCatalan(i, memo);
            BigInteger b = nthCatalan(n-i-1, memo);
            BigInteger c =a.multiply(b);
            ways = ways.add(c);
        }
        
        memo.put(n, ways);
        return ways;
    }
	
}
