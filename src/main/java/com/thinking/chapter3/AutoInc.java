package com.thinking.chapter3;

/**
 * @author Huangcz
 * @date 2019-01-04 17:26
 * @desc xxx
 */
public class AutoInc {

	static void prt(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		int i = 1;
		prt("i : " + i);
		prt("++i : " + (++i));
		prt("i++ : " + (i++));

		prt("i : " + i);
		prt("--i : " + (--i));
		prt("i-- : " + (i--));

		prt("i : " + i);
	}

}
