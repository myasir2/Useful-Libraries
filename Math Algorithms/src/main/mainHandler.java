package main;

import resource.Algorithm;
import resource.RefinedMath;

public class mainHandler 
{
	public static void main(String args[])
	{
		String string = "ISAPALINILAPASI";
		
		System.out.println(string + " is palindrome: " + Algorithm.isPalindromeRecursive(string, 0, string.length() - 1));
	}
}
