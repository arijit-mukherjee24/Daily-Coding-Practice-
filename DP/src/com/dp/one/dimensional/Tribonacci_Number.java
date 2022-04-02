package com.dp.one.dimensional;

import java.util.HashMap;

// 1137. N-th Tribonacci Number

//Sahil - Dp 2
//Recursive TC: O(n)  SC: O(n)
public class Tribonacci_Number {

	public static void main(String[] args) {

	}

	public int tribonacci(int n) {
		return nthTrib(n, new HashMap<Integer, Integer>());
	}

	private int nthTrib(int n, HashMap<Integer, Integer> memo) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;

		int currentKey = n;
		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int a = nthTrib(n - 1, memo);
		int b = nthTrib(n - 2, memo);
		int c = nthTrib(n - 3, memo);

		memo.put(currentKey, a + b + c);
		return a + b + c;
	}

}
