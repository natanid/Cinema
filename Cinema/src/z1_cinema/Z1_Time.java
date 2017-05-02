package z1_cinema;

public class Z1_Time implements Comparable<Z1_Time> {
	/**
	 * 
	 * fields;
	 * 
	 * */
	private int hour;
	private int min;

	/**
	  * 
	  * constructor using fields;
	  * 
	  * */
	
	public Z1_Time(int hour, int min) {
		super();
		this.hour = hour;
		this.min = min;
	}
    
	/**
	 * 
	 * getter for hour;
	 * 
	 * */
	public int getHour() {
		return hour;
	}

	/**
	 * 
	 * setter for hour;
	 * 
	 * */
	
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * 
	 * getter for minutes;
	 * 
	 * */
	
	public int getMin() {
		return min;
	}

	/**
	 * 
	 * setter for minutes;
	 * 
	 * */
	
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 *  to string;
	 * 
	 * */

	@Override
	public String toString() {
		return String.format("%02d:%02d", hour, min);
	}

	/**
	 * method from interface Comparable;
	 * 
	 * */

	@Override
	public int compareTo(Z1_Time o) {
		return hour != o.hour ? hour - o.hour : min - o.min;
	}

	/**
	 * method for transformation time in minutes
	 * 
	 * */

	int asMinutes() {
		return (getHour() * 60) + getMin();
	}
}
