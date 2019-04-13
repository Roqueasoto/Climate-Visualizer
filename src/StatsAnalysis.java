import org.apache.*;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class StatsAnalysis {

	public static void main(String[] args) {
	    double[] v = {1.0, 2.0, 3.0, 4.0, 5.0};
	    StandardDeviation sd = new StandardDeviation(false);
	    System.out.println(sd.evaluate(v));
	    // returns 1.414

	    StandardDeviation sd2 = new StandardDeviation();
	    System.out.println(sd2.evaluate(v));
	}
}
