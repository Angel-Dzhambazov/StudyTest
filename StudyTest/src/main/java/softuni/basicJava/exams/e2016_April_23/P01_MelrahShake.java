/*
 * P01_MelrahShake.java
 *
 * created at 2019-12-12 by a.dzhambazov <YOURMAILADDRESS>
 *
 *  https://www.youtube.com/watch?v=jlyRRXpPMeQ&feature=youtu.be
 *  //mislq che tazi zadacha ne q reshava na video
 *
 *  https://judge.softuni.bg/Contests/Practice/Index/183#0
 */

package softuni.basicJava.exams.e2016_April_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_MelrahShake
{
	private static String noShake = "No shake.";
	private static String shakeIt = "Shaked it.";

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String regex = escapeMetaCharacters(br.readLine());

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		int count = 0;
		while (true)
		{
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(line);
			String tempLine = line;
			try
			{
				while (matcher.find())
				{
					count++;
				}
				if (count > 1)
				{
					tempLine = line.replaceFirst(regex, "");
					tempLine = replaceLast(tempLine, regex, "");
					regex = deleteCharAt(regex);
					System.out.println(shakeIt);
					line = tempLine;
					count = 0;
				} else
				{
					break;
				}
			} catch (IndexOutOfBoundsException e)
			{
				break;
			}
		}
		System.out.println(noShake);
		System.out.println(line);
	}

	private static String replaceLast(String text, String regex, String replacement)
	{
		return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
	}

	private static String deleteCharAt(String inputString)
	{
		StringBuilder sb = new StringBuilder(inputString);
		sb.deleteCharAt((inputString.length() / 2));
		return sb.toString();
	}

	private static String escapeMetaCharacters(String inputString)
	{
		final String[] metaCharacters =
		{ "\\", "^", "$", "{", "}", "[", "]", "(", ")", ".", "*", "+", "?", "|", "<", ">", "-", "&", "%" };

		for (int i = 0; i < metaCharacters.length; i++)
		{
			if (inputString.contains(metaCharacters[i]))
			{
				inputString = inputString.replace(metaCharacters[i], "\\" + metaCharacters[i]);
			}
		}
		return inputString;
	}
}
