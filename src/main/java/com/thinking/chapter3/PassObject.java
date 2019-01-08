package com.thinking.chapter3;

/**
 * @author Huangcz
 * @date 2019-01-04 16:52
 * @desc xxx
 */
public class PassObject {
	static void f(Letter y){
		y.c = 'z';
	}
	public static void main(String[] args) {
		Letter letter = new Letter();
		letter.c = 'a';
		System.out.println("1: letter.c: " + letter.c);
		f(letter);
		System.out.println("1: letter.c: " + letter.c);
	}
}

class Letter{
	char c;
}