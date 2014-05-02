import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class DoubleSquares {
	
	public static int doubleSquares(int num) {
		int counter = 0;
		for (int i = 0; i <= Math.sqrt((double) num / 2); i ++){
			int i_square = i * i;
			int j = (int) Math.sqrt(num - i_square);
			int j_square = j * j;
			if (i_square + j_square == num)
				counter ++;
		}
		return counter;
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    int N = Integer.parseInt(in.readLine().trim());
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		            int num = Integer.parseInt(lineArray[0]);
		            System.out.println(doubleSquares(num));
		        }
		    }
		    
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
