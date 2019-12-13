/*
 * Test.java
 *
 * created at 2019-12-12 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package softuni.basicJava.exams.e2018_Jan_03;

public class Test
{

	public static void main(String[] args)
	{
		System.out.println(replaceLast("foo AB bar AB done", "AB", "--"));

	}

	private static String replaceLast(String text, String regex, String replacement)
	{
		return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
	}
}
