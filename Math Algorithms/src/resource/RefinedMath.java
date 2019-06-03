package resource;

import java.util.ArrayList;
import java.util.HashSet;

public class RefinedMath 
{
	public static int getSumOfAllMultiples(int limit, int multipliers[])
	{
		HashSet<Integer> multiples = new HashSet<>();
		int sum = 0;
		
		for(int i = 1; i < limit; i++)
		{
			for(int multiplier : multipliers)
			{
				if(i % multiplier == 0)
					multiples.add(i);
			}
		}
		
		for(int multiple : multiples)
		{
			sum += multiple;
		}

		return sum;
	}
	
	public static int sumOfFibonacci(int limit, boolean isSumEven)
	{
		int evenSum = 2;
		int oddSum = 1;
		int x = 1;
		int y = 2;
		int z = 0;
		
		while(z < limit)
		{
			z = x + y;
			x = y;
			y = z;
			
			if(z % 2 == 0)
				evenSum += z;
			else
				oddSum += z;
		}
		
		return (isSumEven ? evenSum : oddSum);
	}
	
	public static int findIndexOfFiboTerm(int limit)
	{
		double phi = 1.618;
		int index = (int) Math.round(((Math.log(10) * 999) + (Math.log(5) / 2)) / Math.log(phi));
		
		return index;
	}
	
	public static long largestPrimeFactor(long number)
	{
		// Keep dividing number by 2 until can't be done anymore
		while(number % 2 == 0)
			number /= 2;
		
		// Next prime factor after 1 is 3 and after all primes are odd.
		// Continue loop and check only for odd numbers
		for(long factor = 3; factor < number; factor += 2)
		{
			while(number % factor == 0 && factor < number)
				number /= factor;
		}
		
		return number;
	}
	
	
	public static boolean isPrime(int number)
	{
		for(int i = 2; i <= Math.sqrt(number); i++)
		{
			if(number % i == 0)
				return false;
		}
		
		return true;
	}
}
