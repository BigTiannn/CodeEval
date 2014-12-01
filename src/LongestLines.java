/**
 * https://www.codeeval.com/open_challenges/2/
 * Write a program which reads a file and prints to stdout the specified number of 
 * the longest lines that are sorted based on their length in descending order.
 * 
 * @author BigTiannn {11-30-2014}
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LongestLines {
	
	// increasing order
	// Pay attention: k-largest problem should use min-heap while k-smallest problem uses max-heap
	public static class StringLengthComparator implements Comparator<String> {
	    @Override
	    public int compare(String x, String y) {
	    	return x.length() - y.length();
	    }
	}

	public static void main (String[] args) {
		File file = new File(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    int k = 0;
		    List<String> list = new ArrayList<>();
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		        	if (k == 0) {
		        		k = Integer.parseInt(lineArray[0]);
		        	} else {
		        		list.add(line);
		        	}
		        }
		    }
		    
		    Comparator<String> comparator = new StringLengthComparator();
		    PriorityQueue<String> queue = new PriorityQueue(k, comparator);
		    if (k >= list.size()) {
		    	queue.addAll(list);
		    } else {
		    	int i = 0;
		    	while (i < k) {
		    		queue.add(list.get(i ++));
		    	}
		    	while (i < list.size()) {
		    		int currMin = queue.peek().length();
		    		if (list.get(i).length() > currMin) {
		    			queue.poll();
			    		queue.add(list.get(i));
		    		}
		    		i ++;
		    	}
		    }
		    
		    // print
		    List<String> res = new ArrayList<>();
		    while (!queue.isEmpty()) {
		    	res.add(0, queue.poll());
		    }
		    for (String s : res)
		    	System.out.println(s);
		    
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
