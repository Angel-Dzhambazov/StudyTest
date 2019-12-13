/*
 * P01_Agency.java
 *
 * created at 2019-11-19 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package softuni.basicJava.exams.e2018_August_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P01_Agency
{
	private static Deque ids = new ArrayDeque<>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		// String line = bReader.readLine();

		String line = "111 222 333";

		fillStackWithIDs(line);

		while ("stop".equals(line))
		{

			line = bReader.readLine();
		}

		// queue for IDs
		// queue for Agents
		// map for agents and IDs

	}

	private static void fillStackWithIDs(String listOfIDs)
	{
		String[] initialIDs = listOfIDs.split("\\s+");
		System.out.println(initialIDs.length);
		for (String currentID : initialIDs)
		{
			System.out.println("one");
			ids.add(currentID);
		}
		System.out.println(ids.size());

		for (int i = 0; i < 3; i++)
		{
			System.out.println(ids.pollLast());
		}
	}
}
