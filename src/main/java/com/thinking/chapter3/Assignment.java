package com.thinking.chapter3;

/**
 * @author Huangcz
 * @date 2019-01-03 17:58
 * @desc xxx
 */
public class Assignment {

	public static void main(String[] args) {

		Number number1 = new Number();
		Number number2 = new Number();

		number1.i = 4;
		number2.i = 9;

		System.out.println("1: n1.i: " + number1.i + ", n2.i: " + number2.i);

		number1 = number2;

		System.out.println("2: n1.i: " + number1.i + ", n2.i: " + number2.i);

		number1.i = 27;

		System.out.println("3: n1.i: " + number1.i + ", n2.i: " + number2.i);
	}




}



class Number{
	int i;
}
