import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class UglyNumbers {
	
	// https://www.codeeval.com/open_challenges/42/
	
	// A number is ugly if it was divisible by any of the one-digit primes (2, 3, 5 or 7)
	private static boolean isUgly(int num) {
		if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0)
			return true;
		
		return false;
	}
	
	private static ArrayList<Integer> calculateFromFront(String str, int ptr){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (ptr == str.length() - 1) {
			result.add(str.charAt(ptr) - '0');
			return result;
		}
		
		int prefix = 0;
		for (int i = ptr; i < str.length(); i ++) {
			prefix = prefix * 10 + str.charAt(i) - '0';
			if (i == str.length() - 1) {
				result.add(prefix);
			}
			ArrayList<Integer> list = calculateFromFront(str, i + 1);
			for (int j = 0; j < list.size(); j ++) {
				result.add(prefix + list.get(j));
				result.add(prefix - list.get(j));
			}
		}
		
		return result;
	}
	
	private static ArrayList<Integer> calculateFromBack(String str, int ptr) {
		ArrayList<Integer> result = new ArrayList<>();
		if (ptr == 0) {
			result.add(str.charAt(ptr) - '0');
			return result;
		}
		
		int pow = 1;
		int postfix = 0;
		for (int i = ptr; i >= 0; i --) {
			postfix += (str.charAt(i) - '0') * pow;
			pow *= 10;
			if (i == 0)
				result.add(postfix);
			ArrayList<Integer> list = calculateFromBack(str, i - 1);
			for (int j = 0; j < list.size(); j ++) {
				result.add(list.get(j) + postfix);
				result.add(list.get(j) - postfix);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
//		String str = "578";
//		ArrayList<Integer> res1 = calculateFromBack(str, str.length() - 1);
//		ArrayList<Integer> res2 = calculateFromFront(str, 0);
//		System.out.println(Arrays.toString(res1.toArray()));
//		System.out.println(Arrays.toString(res2.toArray()));
		
		File file = new File(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		            ArrayList<Integer> list = calculateFromBack(lineArray[0], lineArray[0].length() - 1);
		            int counter = 0;
		            for (int i = 0; i < list.size(); i ++) {
		            	if (isUgly(list.get(i)))
		            		counter ++;
		            }
		            System.out.println(counter);
		        }
		    }
		    
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
