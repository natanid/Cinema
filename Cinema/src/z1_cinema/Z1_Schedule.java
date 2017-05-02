package z1_cinema;

import java.util.Set;
import java.util.TreeSet;

public class Z1_Schedule {
	/**
	 * 
	 * fields; 
	 * 
	 * */
	
	private Set<Z1_Seanse> seanses;
	
	/**
	 * 
	 * constructor;
	 * 
	 * */
	
	public Z1_Schedule(Set<Z1_Seanse> seanse) {
		this.seanses = new TreeSet<Z1_Seanse>();
	}
    
	/**
     * 
     * getter for seanses;
     *
     * */
	
	public Set<Z1_Seanse> getSeanse() {
		return seanses;
	}
    
	/**
     * 
     * setter for seanses;
     * 
     * */
	
	public void setSeanse(TreeSet<Z1_Seanse> seanses) {
		this.seanses = seanses;
	}
    
	/**
     * 
     * to string;
     * 
     * */
	
	@Override
	public String toString() {
		return "seanses=" + seanses + "";
	}
    
	/**
    * method for add movie to treeset;
    * 
    * */
	
	void addMovie(Z1_Seanse seanse){
		if(seanse.getStartTime().asMinutes()>=Z1_Main_Cinema.OPENCINEMA.asMinutes()
		&&seanse.getEndTime().asMinutes()<=Z1_Main_Cinema.CLOSECINEMA.asMinutes())
		seanses.add(seanse);Z1_Cinema.showAllSeanses();
	}
	
	/**
	 * 
	 * method for remove seanse
	 * 
	 * */
    
    void removeSeanse(Z1_Seanse seanse) {
		seanses.remove(seanse);
	}
  
}   
