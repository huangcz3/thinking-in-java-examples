package com.thinking.chapter3;

import java.util.Hashtable;

/**
 * @author Huangcz
 * @date 2019-01-04 17:38
 * @desc xxx
 */
public class Equivalence {
	public static void main(String[] args) {
		Integer n1 = new Integer(47);

		Integer n2 = new Integer(47);



		System.out.println(n1 == n2);

		System.out.println(n1 != n2);

		System.out.println(n1.equals(n2));

		Value value1 = new Value();
		Value value2 = new Value();

		value1.i = value2.i = 20;
		System.out.println(value1.equals(value2));
	}
}

class Value{
	int i;
}
