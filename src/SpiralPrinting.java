import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/***
 * https://www.codeeval.com/open_challenges/57/
 * @author BigTiannn
 *
 */
public class SpiralPrinting {
	
	public static void spriralPrinting(int n, int m, String[] chars) {
		int layer = Math.min(n, m) / 2;
		String[][] matrix = new String[n][m];
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++){
				matrix[i][j] = chars[i * m + j];
			}
		}
		
		for (int i = 0; i < layer; i ++) {
			// top row
			for (int j = i; j < m - i - 1; j ++) {
				System.out.print(matrix[i][j] + " ");
			}
			// right column
			for (int j = i; j < n - i - 1; j ++) {
				System.out.print(matrix[j][m - i - 1] + " ");
			}
			// bottom row
			for (int j = m - i - 1; j > i; j --) {
				System.out.print(matrix[n - i - 1][j] + " ");
			}
			// left column
			for (int j = n - i - 1; j > i; j --) {
				System.out.print(matrix[j][i] + " ");
			}
		}
		
		if (m % 2 == 1 && n % 2 == 1) {
			if (m >= n) {
				for (int i = layer; i < m - layer; i ++)
					System.out.print(matrix[layer][i] + " ");
			} else {
				for (int i = layer; i < n - layer; i ++)
					System.out.print(matrix[i][layer] + " ");
			}
		}
		
		if (m % 2 == 1 && n % 2 == 0 && n > m) {
			for (int i = layer; i < n - layer; i ++)
				System.out.print(matrix[i][layer] + " ");
		}
		
		if (n % 2 == 1 && m % 2 == 0 && m > n) {
			for (int i = layer; i < m - layer; i ++)
				System.out.print(matrix[layer][i] + " ");
		}
		
		System.out.println();
		return;
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split(";");
		        if (lineArray.length > 0) {
		            int n = Integer.parseInt(lineArray[0].trim());
		            int m = Integer.parseInt(lineArray[1].trim());
		            String[] chars = lineArray[2].trim().split("\\s");
		            spriralPrinting(n, m, chars);
		        }
		    }
		    
		    in.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
