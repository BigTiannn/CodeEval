import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class BayBridge {
	
	class Point {
		double x;
		double y;
		
		Point(double xx, double yy){
			this.x = xx;
			this.y = yy;
		}
	}
	
	public double crossProduct(Point o, Point a, Point b) {
	    return (a.x-o.x) * (b.y-o.y) - (a.y-o.y) * (b.x-o.x);
	}
	
	// p1 and p2 define a line while p3 and p4 define another
	// return whether two segments are intersected
	public boolean isIntersected (Point p1, Point p2, Point p3, Point p4) {
		double c1 = crossProduct(p1, p2, p3);
		double c2 = crossProduct(p1, p2, p4);
		double c3 = crossProduct(p3, p4, p1);
		double c4 = crossProduct(p3, p4, p2);
		
		if (c1 * c2 < 0 && c3 * c4 < 0)
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		BayBridge bb = new BayBridge();
		Point p1 = bb.new Point(1, 0);
		Point p2 = bb.new Point(5, 0);
		Point p3 = bb.new Point(3, 3);
		Point p4 = bb.new Point(3, -3);
		System.out.println(bb.isIntersected(p1, p2, p3, p4));
		
//		File file = new File(args[0]);
//		try {
//			BufferedReader in = new BufferedReader(new FileReader(file));
//		    String line;
//		    int N = Integer.parseInt(in.readLine().trim());
//		    while ((line = in.readLine()) != null) {
//		        String[] lineArray = line.split("\\s");
//		        if (lineArray.length > 0) {
//		            int num = Integer.parseInt(lineArray[0]);
//		        }
//		    }
//		    
//		    in.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
