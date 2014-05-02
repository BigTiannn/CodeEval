import java.util.ArrayList;


public class SumOfPrimes {
	
	// Write a program to determine the sum of the first 1000 prime numbers.
	public static boolean isPrime(int num, ArrayList<Integer> plist) {
		for (int i = 1; i < plist.size(); i ++) {
			int divisor = plist.get(i);
			if (divisor * divisor > num)
				return true;
			if (num % divisor == 0)
				return false;
		}
		
		return true;
	}
	
	// only test 6n+1 and 6n+5
	public static void findNPrimes (int N) {
		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		
		int counter = 3;
		int sum = 10;
		int step = 2;
		int curr = 6 * 1 + 1;
		
		while (counter < N) {
			if (isPrime(curr, primes)) {
				primes.add(curr);
				counter ++;
				sum += curr;
			}
			step = 6 - step;
			curr += step;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNPrimes(1000);
	}

}
