package z1_cinema;

public class Z1_Seanse implements Comparable<Z1_Seanse>{
	
	/**
	 * 
	 * fields;
	 * 
	 * */
	
	private Z1_Movie movie;
	private Z1_Time startTime;
	private Z1_Time endTime;
	
	/**
	 * 
	 * consructor using fields;
	 * 
	 * */
	
	public Z1_Seanse(Z1_Movie movie, Z1_Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		endTime();
	}

	/**
	 * 
	 * getter for Movie;
	 * 
	 * */
	
	public Z1_Movie getMovie() {
		return movie;
	}

	/**
	 * 
	 * setter for Movie;
	 * 
	 * */
	
	public void setMovie(Z1_Movie movie) {
		this.movie = movie;
	}

	/**
	 * 
	 * getter for startTime;
	 * 
	 * */
	
	public Z1_Time getStartTime() {
		return startTime;
	}

	/**
	 * 
	 * setter for startTime;
	 * 
	 * */
	
	public void setStartTime(Z1_Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * 
	 * getter for endTime;
	 * 
	 * */
	
	public Z1_Time getEndTime() {
		return endTime;
	}

	/**
	 * 
	 * to String;
	 * 
	 * */
	
	@Override
	public String toString() {
		return "Seanse " + movie + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}

	/**
	 * 
	 * method from interface Comparable;
	 * 
	 * */
	
	@Override
	public int compareTo(Z1_Seanse o) {
		        if (o.endTime.compareTo(startTime) < 0) {
		            return 1;
		        } return (o.startTime.compareTo(endTime) > 0) ? -1 : 0;
    }

	/**
	 * 
	 * method calculate endTime;
	 * 
	 * */
	
	void endTime() {
	   this.endTime = new Z1_Time(startTime.getHour() + movie.getDuration().getHour(),startTime.getMin() + movie.getDuration().getMin());
		if (endTime.getMin() > 59) {
			endTime.setHour(endTime.getHour() + 1);
			endTime.setMin(endTime.getMin() - 60);
		}
    }

}
