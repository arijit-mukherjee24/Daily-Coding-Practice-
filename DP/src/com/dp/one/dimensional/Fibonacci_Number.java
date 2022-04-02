package com.dp.one.dimensional;

import java.util.HashMap;

// 509. Fibonacci Number

//Sahil - Dp 1
//Recursive TC: O(2^n)  SC: O(n)
//// Recursive TC: O(n)  SC: O(n)
public class Fibonacci_Number {

	public static void main(String[] args) {

	}

	public int fib(int n) {
		return nthFib(n, new HashMap<Integer, Integer>());
	}

	private int nthFib(int n, HashMap<Integer, Integer> memo) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int currentKey = n;

		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int a = nthFib(n - 1, memo);
		int b = nthFib(n - 2, memo);

		memo.put(currentKey, a + b);
		return a + b;
	}

}
