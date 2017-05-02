package z1_cinema;

public class Z1_Movie {
	
	/**
	 * 
	 * fields;
	 * 
	 * */

	private String title;
	private Z1_Time duration;

	/**
	 * 
	 * constructor using fields;
	 * 
	 * */
	
	public Z1_Movie(String title, Z1_Time duration) {
		super();
		this.title = title;
		this.duration = duration;
	}

	/**
	 * 
	 * getter for title;
	 * 
	 * */
	
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * setter for title;
	 * 
	 * */
	
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * getter for duration;
	 * 
	 * */
	
	public Z1_Time getDuration() {
		return duration;
	}

	/**
	 * 
	 * setter for duration;
	 * 
	 * */
	
	public void setDuration(Z1_Time duration) {
		this.duration = duration;
	}

	/**
	 * 
	 * to String;
	 * 
	 * */
	
	@Override
	public String toString() {
		return "" + title + ", duration=" + duration + "";
	}
}
