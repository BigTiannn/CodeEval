
public class PrimePalindrome {
	
	// Write a program to determine the biggest prime palindrome under 1000.
	// Thought:
	// It must be 3-digit and may only end in 1,3,5,7,9.
	public static boolean isPrime (int num) {
		for (int i = 3; i * i < num; i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] seed = {1, 3, 5, 7, 9};
		
		for (int i = seed.length - 1; i >= 0; i --) {
			int base = seed[i] * 100 + seed[i];
			for (int j = 9; j >= 0; j --) {
				int curr = base + j * 10;
				if (isPrime(curr)) {
					System.out.println(curr);
					return;
				}
			}
		}
	}

}
