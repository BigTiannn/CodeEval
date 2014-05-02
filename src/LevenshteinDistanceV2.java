import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//-Xmx256m -Xms256m -Xss256k
public class LevenshteinDistanceV2 {
	public static ArrayList<String> Dictionary = new ArrayList<>();
	
    private static int LevenshteinDist(String word1, String word2) {
        int m = word1.length(), n = word2.length();
    	int[][] matrix = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i ++) {
			matrix[i][0] = i;
		}
		
		for (int j = 0; j <= n; j ++) {
			matrix[0][j] = j;
		}
		
		for (int i = 1; i <= m; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)){
					matrix[i][j] = matrix[i-1][j-1];
				} else {
					matrix[i][j] = min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1;
				}
			}
		}
		
		return matrix[m][n];
	}
    
    private static int min(int num1, int num2, int num3) {
    	int middle = num1 < num2 ? num1 : num2;
		return middle < num3 ? middle : num3;
	}
    
    public static int searchSocialNetwork(String target) {
    	int N = Dictionary.size(), friend = 0;
		Queue<Integer> waitingQueue = new LinkedList<>();
		byte[] visited = new byte[N];
		
		for (int i = 0; i < N; i ++) {
			if (Math.abs(target.length() - Dictionary.get(i).length()) > 1)
				continue;
			if (LevenshteinDist(target, Dictionary.get(i)) <= 1) {
				waitingQueue.add(i);
				visited[i] = 0x01;
				friend ++;
			}
		}
		
		while(!waitingQueue.isEmpty()) {
			int wordIndex = waitingQueue.poll();
			for (int i = 0; i < N; i ++) {
				if (visited[i] == 0x01)
					continue;
				if (Math.abs(Dictionary.get(wordIndex).length() - Dictionary.get(i).length()) > 1)
					continue;
				if (LevenshteinDist(Dictionary.get(wordIndex), Dictionary.get(i)) <= 1) {
					waitingQueue.add(i);
					visited[i] = 0x01;
					friend ++;
				}
			}
		}
        
        return friend;
    }
    
    public static void main (String[] args) {
        File file = new File(args[0]);
    	try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    ArrayList<String> target = new ArrayList<>();
		    boolean readingDic = false;
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		            if (lineArray.length == 3) {
		            	readingDic = true;
		            } 
		            if (!readingDic)
		            	target.add(lineArray[0]);
		            else
		            	Dictionary.add(lineArray[0]);
		        }
		    }
		    
		    in.close();
		    
		    for (String word : target) {
		    	System.out.println(searchSocialNetwork(word));
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
