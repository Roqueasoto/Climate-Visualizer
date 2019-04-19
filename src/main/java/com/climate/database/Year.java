
public class Year{
	/*
	 *  Contains temperature data for each month
	 */
	
	private double jan;
	private double feb;
	private double mar;
	private double apr;
	private double may;
	private double jun;
	private double jul;
	private double aug;
	private double sep;
	private double oct;
	private double nov;
	private double dec;
	
	public Year(double jan, double feb, double mar, double apr, double may, double jun, double jul, double aug,
			double sep, double oct, double nov, double dec) {
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		this.apr = apr;
		this.may = may;
		this.jun = jun;
		this.jul = jul;
		this.aug = aug;
		this.sep = sep;
		this.oct = oct;
		this.nov = nov;
		this.dec = dec;
	}

	public double getJan() {
		return jan;
	}

	public double getFeb() {
		return feb;
	}

	public double getMar() {
		return mar;
	}

	public double getApr() {
		return apr;
	}

	public double getMay() {
		return may;
	}

	public double getJun() {
		return jun;
	}

	public double getJul() {
		return jul;
	}

	public double getAug() {
		return aug;
	}

	public double getSep() {
		return sep;
	}

	public double getOct() {
		return oct;
	}

	public double getNov() {
		return nov;
	}

	public double getDec() {
		return dec;
	}
	

}
