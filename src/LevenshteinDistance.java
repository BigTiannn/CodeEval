import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/***
 * https://www.codeeval.com/open_challenges/58/
 * Constraints: 
 * Number of test cases N in range(15, 30) 
 * The word list always will be the same and it's length will be around 10000 words 
 * @author BigTiannn
 */

public class LevenshteinDistance {
	
	public ArrayList<String> Dictionary = null;
	// Key is the smallest index of the word in the social network
	// Value is the size of the whole social network
	public Map<Integer, Integer> SocialNetworkSizeMap = new HashMap<>();
	// map every node to the social network it belongs to
	public Map<Integer, Integer> FriendsMap = new HashMap<>();
	
	private static int LevenshteinDist(String word1, String word2) {
		if ((word1 == null || word1.length() ==0) && word2 != null) 
			return word2.length();
		if ((word2 == null || word2.length() ==0) && word1 != null)
			return word1.length();
		if (word1 == null && word2 == null)
			return 0;
		
		int m = word1.length(), n = word2.length();
		int[][] dist = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i ++)
			dist[i][0] = i;
		
		for (int j = 0; j <= n; j ++)
			dist[0][j] = j;
		
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if (word1.charAt(i) == word2.charAt(j))
					dist[i+1][j+1] = dist[i][j];
				else
					dist[i+1][j+1] = min(dist[i][j], dist[i][j+1], dist[i+1][j]) + 1;
			}
		}
		
		return dist[m][n];
		
	}
	
	private static int min(int num1, int num2, int num3) {
		int middle = num1 < num2 ? num1 : num2;
		return middle < num3 ? middle : num3;
	}
	
	public int search(String target) {
		int N = this.Dictionary.size(), friend = 0;
		Queue<Integer> seedQueue = new LinkedList<>();
		int[] visited = new int[N];
		Set<Integer> seedSet = new HashSet<>();
		
		for (int i = 0; i < N; i ++) {
			if (Math.abs(target.length() - this.Dictionary.get(i).length()) > 1) {
				continue;
			} else if (LevenshteinDist(target, this.Dictionary.get(i)) <= 1) {
				if (this.FriendsMap.containsKey(i)) {
					int sn_id = this.FriendsMap.get(i);
					if (!seedSet.contains(sn_id)) {
						friend += this.SocialNetworkSizeMap.get(sn_id);
						seedSet.add(sn_id);
						continue;
					}
				} else {
					seedQueue.add(i);
				}
			}
		}
		
		while(!seedQueue.isEmpty()) {
			int currSeed = seedQueue.poll();
			if (visited[currSeed] == 1) {
				continue;
			}
			visited[currSeed] = 1;
			this.FriendsMap.put(currSeed, currSeed);
			Queue<Integer> waitingQueue = new LinkedList<>();
			waitingQueue.add(currSeed);
			int counter = 1;
			while (!waitingQueue.isEmpty()) {
				int k = waitingQueue.poll();
				for (int i = 0; i < N; i ++) {
					if (visited[i] == 1)
						continue;
					if (Math.abs(this.Dictionary.get(k).length() - this.Dictionary.get(i).length()) > 1)
						continue;
					if (LevenshteinDist(this.Dictionary.get(k), this.Dictionary.get(i)) <= 1) {
						waitingQueue.add(i);
						visited[i] = 1;
						counter ++;
						this.FriendsMap.put(i, currSeed);
					}
				}
			}
			friend += counter;
			this.SocialNetworkSizeMap.put(currSeed, counter);
		}
		
		return friend;
	}
	
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    ArrayList<String> target = new ArrayList<>();
		    ArrayList<String> dic = new ArrayList<>();
		    ArrayList<String> tmp = target;
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		            if (lineArray.length == 3) {
		            	tmp = dic;
		            } else {
		            	tmp.add(lineArray[0]);
		            }
		        }
		    }
		    
		    in.close();
		    
		    LevenshteinDistance LDworker = new LevenshteinDistance();
		    LDworker.Dictionary = dic;
		    
		    for (int i = 0; i < target.size(); i ++) {
		    	String word = target.get(i);
		    	System.out.println(LDworker.search(word));
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
