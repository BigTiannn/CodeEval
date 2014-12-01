import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Package {
	
	class Item {
		int index;
		float weight;
		int value;
		
		Item(int idx, float w, int val) {
			this.index = idx;
			this.weight = w;
			this.value = val;
		}
	}
	
	public ArrayList<Integer> getMaxValue(int W,ArrayList<Item> itemlist) {
		ArrayList<Integer> items;
		int[] valarray = new int[itemlist.size() + 1];
		Arrays.fill(valarray, 0);
		
		int curr_weight_sum = 0;
		for (int i = 0; i < itemlist.size(); i ++) {
			for (int j = 0; j < W; j ++) {
				;
			}
		}
		
		return items;
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		String linePatternStr = ":\\s\\(|\\)\\s\\(|\\)";
		Pattern pattern = Pattern.compile(linePatternStr);
		
		Package pac = new Package();
		
    	try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		        String[] ss = pattern.split(line.trim());
		        if (ss.length <= 0)
		        	continue;
		        int weightLimit = Integer.parseInt(ss[0].trim());
		        ArrayList<Item> itemlist = new ArrayList<>();
		        for	(int i = 1; i < ss.length; i ++) {
		        	String[] s = ss[i].split(",");
		        	if (s.length <= 0)
		        		continue;
		        	int index = Integer.parseInt(s[0]);
		        	float weight = Float.parseFloat(s[1]);
		        	int value =Integer.parseInt(s[2].substring(1));
		        	itemlist.add(pac.new Item(index, weight, value));
		        }
		        ArrayList<Integer> ret = pac.getMaxValue(weightLimit, itemlist);
		        if (ret == null)
		        	System.out.println("-");
		        else {
		        	for (int i = 0; i < ret.size(); i ++) {
		        		if (i != ret.size() - 1)
		        			System.out.print(ret.get(i) + ",");
		        		else
		        			System.out.println(ret.get(i));
		        	}
		        }
		    }
		    
		    in.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
