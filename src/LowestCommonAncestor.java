/**
 * https://www.codeeval.com/open_challenges/11/
 * Write a program to determine the lowest common ancestor of two nodes in a binary search tree. 
 * 
 * @author BigTiannn {11-30-2014}
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LowestCommonAncestor {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	
	public static TreeNode buildTestBST() {
		TreeNode node1 = new TreeNode(30);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(52);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(20);
		TreeNode node6 = new TreeNode(10);
		TreeNode node7 = new TreeNode(29);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node6;
		node5.right = node7;
		
		return node1;
	}
	
	// val1 is smaller than val2
	public static int LCA(TreeNode root, int val1, int val2) {
		int res = -1;
		
		// dfs
		while (root != null) {
			if (root.val >= val1 && root.val <= val2) {
				res = root.val;
				return res;
			} else if (root.val > val2) {
				root = root.left;
			} else if (root.val < val1) {
				root = root.right;
			}
		}
		
		return -1;
	}

	public static void main (String[] args) {
		File file = new File(args[0]);
		TreeNode root = buildTestBST();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		        String[] lineArray = line.split("\\s");
		        if (lineArray.length > 0) {
		        	int node1 = Integer.parseInt(lineArray[0]);
		        	int node2 = Integer.parseInt(lineArray[1]);
		        	if (node1 < node2)
		        		System.out.println(LCA(root, node1, node2));
		        	else
		        		System.out.println(LCA(root, node2, node1));
		        }
		    }
		    
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
