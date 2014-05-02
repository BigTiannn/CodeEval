import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class PrimeNumbers {
	
	// Print out the prime numbers less than a given number N. 
	// For bonus points your solution should run in N*(log(N)) time or better. 
	// You may assume that N is always a positive integer.
	
	public static boolean isPrime(int num) {
		for (int i = 3; i * i <= num; i ++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static ArrayList<Integer> finePrimesUnderN(int N) {
		ArrayList<Integer> result = new ArrayList<>();
		
		if (N >= 2) {
			result.add(2);
			for (int i = 3; i < N; i += 2) {
				if (isPrime(i))
					result.add(i);
			}
		}
		
		return result;
	}
 
	public static void main(String[] args) {
		File file = new File(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		            int border = Integer.parseInt(lineArray[0]);
		            ArrayList<Integer> result = finePrimesUnderN(border);
		            for (int i = 0; i < result.size(); i ++) {
		            	if(i != result.size() - 1)
		            		System.out.print(result.get(i) + ",");
		            	else
		            		System.out.println(result.get(i));
		            }
		        }
		    }
		    
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

}
