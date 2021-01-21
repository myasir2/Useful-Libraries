package resource;

public class Algorithm 
{
	public static int binarySearchIterative(int[] array, int number)
	{
		int left = 0;
		int right = array.length -1;
		
		while(left <= right)
		{
			int mid = (left + right) / 2;
			
			if(array[mid] == number)
				return mid;
			else if(number > array[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		return -1;
	}
	
	public static int binarySearchRecursive(int[] array, int number, int left, int right)
	{
		if(left > right)
			return -1;
		
		int mid = (left + right) / 2;
		
		if(array[mid] == number)
			return mid;
		else if(number > array[mid])
			return binarySearchRecursive(array, number, mid + 1, right);
		else
			return binarySearchRecursive(array, number, left, mid - 1);
	}

	public static boolean isPalindromeIterative(String str)
	{
		int low = 0;
		int high = str.length() - 1;

		while(low < high)
		{
			if(str.charAt(low) != str.charAt(high)) {
				return false;
			}

			low++;
			high--;
		}

		return true;
	}
	
	public static boolean isPalindromeRecursive(String string, int startIndex, int endIndex)
	{
		if(startIndex >= endIndex)
			return true;
		
		return (string.charAt(startIndex) == string.charAt(endIndex) && isPalindromeRecursive(string, startIndex + 1, endIndex - 1));
	}
}
