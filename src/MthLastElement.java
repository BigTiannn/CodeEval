import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class MthLastElement {
	
	// Write a program to determine the Mth to last element of a list. 
	// https://www.codeeval.com/open_challenges/10/

	public static void main(String[] args) {
		File file = new File(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		            //todo:
		        	int mth = Integer.parseInt(lineArray[lineArray.length - 1]);
		        	if (mth >  lineArray.length - 1) {
		        		System.out.println();
		        	} else {
		        		System.out.println(lineArray[lineArray.length - 1 - mth]);
		        	}
		        }
		    }
		    
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
