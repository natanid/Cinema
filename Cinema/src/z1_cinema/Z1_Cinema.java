package z1_cinema;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

public class Z1_Cinema {
	
	/**
	 * 
	 * field;
	 * 
	 * */
	
	public static final Map<Z1_Days, Z1_Schedule> daysAndMovie = new TreeMap<Z1_Days, Z1_Schedule>();

	/**
	 * 
	 * default constructor;
	 * 
	 * */
	
	Z1_Cinema() {
		super();
	}
    
	/**
     * 
     * getter for daysAndMovie;
     * 
     * */
	
	Map<Z1_Days, Z1_Schedule> getDaysAndMovie() {
		return daysAndMovie;
	}

	/**
	 * 
	 * to string;
	 * 
	 * */
	
	@Override
	public String toString() {
		return "Cinema [daysAndMovie=" + daysAndMovie + "]";
	}
	
	/**
	 * method for add keys to map ;
	 * 
	 * */
	 void addDaysToMap() {
		for (Z1_Days day : Z1_Days.values()) {
			daysAndMovie.put(day, new Z1_Schedule(new TreeSet<Z1_Seanse>()));
		}
	}
	
	/**
	 * method for show all map ;
	 * 
	 * */
    static void showAllSeanses(){
    	 for (Map.Entry<Z1_Days, Z1_Schedule> cinema: daysAndMovie.entrySet())
    		 System.out.println(cinema);
     }

	/**
	 * container for create  movie; 
	 * 
	 * */
	
	/**
	 * method for create movie ;
	 *  
	 * 
	 * */
	
	void addMovie()  {
		Z1_Movie movie = new Z1_Movie(titleoffilm(), newTime());
		createSeanse(movie);
	}

	/**
	 * method for create seanse @
	 *  
	 * 
	 * */
	
	void createSeanse(Z1_Movie movie) {
		Z1_Seanse seanse = new Z1_Seanse(movie, newTimeFromScanner());
		add(seanse);
	}

	/**
	 * method for newTime() movie
	 * 
	 * */
	
	Z1_Time newTime() {
		Z1_Time time = new Z1_Time(hour(), min());
		return time;
	}

	/**
	 * method for newTime() movie;
	 * 
	 * 
	 * */
	
	Z1_Time newTimeFromScanner()  {
		Z1_Time time = new Z1_Time(scannerHour(), scannerMin());
		return time;
	}

	/**
	 * method for make random hour;
	 * 
	 * */
	
	public int hour() {
		return 1 + (int) +(Math.random() * 2);

	}

	/**
	 * method for make random min;
	 * 
	 * */
	
	public int min() {
		return (int) +(Math.random() * 60);
	}

	/**
	 * method int hour from scanner;
	 * 
	 * */
	
	int scannerHour()throws NumberFormatException{
		System.out.println("input hour start seanse ");
		try {int hour  =  Integer.parseInt(Z1_Main_Cinema.scanner.next());
		        return hour<=24&&hour>=0?hour:scannerHour();
		    } catch (NumberFormatException e) {
		        return scannerHour();}
	}
	 
	 /**
	 * method int min from scanner;
	 * 
	 * */

	int scannerMin()throws NumberFormatException{
		System.out.println("input min start seanse ");
		try {int minutes = Integer.parseInt(Z1_Main_Cinema.scanner.next());
		        return minutes<=59&&minutes>=0?minutes:scannerMin();
		    } catch (NumberFormatException e) {
		        return scannerMin();} 
	}

	/**
	 * method String generator;
	 * 
	 * */
	
	String titleoffilm() {
		return UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "")
				.substring(0, 5).toUpperCase();
	}
	
	/**
	 * method String from scanner;
	 * 
	 * */
	
	String nameDays() {
		System.out.println("input day ");
		 return Z1_Main_Cinema.scanner.next();
	}
	
	/**
	 * methods for check add values; 
	 * 
	 * */
	
	void add(Z1_Seanse seanse){
	  boolean search = false;
	  String day = nameDays();
	     for (Map.Entry<Z1_Days, Z1_Schedule> mep: daysAndMovie.entrySet()){
    	     if((mep.getKey().name()).equalsIgnoreCase(day)){ mep.getValue().addMovie(seanse);search = true;}}
    	       if(!search){System.out.println("day did not exist");System.out.println();}
	}
	
	/**
	 * container for  make seanses and add to cinema
	 * here will be use some methods from container 
	 * for create movie ;
	 * 
	 * */
	
    /**
     * 
     * method govern existence movie in the
     * timetable and create new seanse;
     * 
     * */	
    	
    void addSeanses(){
    	try{
    	String title ="";
    	Z1_Time  duration = null ;
    	boolean search= false;
    	String nameOfMovie =inputNameOfMovieFromScanner();
    	for (Map.Entry<Z1_Days, Z1_Schedule> mep: daysAndMovie.entrySet()){
    	    for (Z1_Seanse seanse:mep.getValue().getSeanse()) {
		        if(seanse.getMovie().getTitle().equalsIgnoreCase(nameOfMovie)){	
		        	duration = seanse.getMovie().getDuration();
		        	title = seanse.getMovie().getTitle();
		        	search = true;}}}
    	     if(search)
    	     createSeanse(new Z1_Movie(title,duration));
    	     else{System.out.println("movie not found");}
    	}catch(ConcurrentModificationException e){}
    }    		
  
   /**
    * 
    * method receive name of movie from scanner 
    * 
    * 
    * */
    
    String inputNameOfMovieFromScanner(){
    	System.out.println("enter name of movie");
		  return Z1_Main_Cinema.scanner.next();
    }
    
   /**
     * 
     * container for remove seanses;
     * 
     * */    
    
    /**
     * 
     * method checking by day,title and start seanse
     * before remove;
     * 
     * */
    
    void removeSeanse(){
    	try{
    	String day =nameDays(),nameOfMovie=inputNameOfMovieFromScanner();
    	int hour = scannerHour(),min =scannerMin();
    	for (Map.Entry<Z1_Days, Z1_Schedule> mep: daysAndMovie.entrySet()){
    	  if(day.equalsIgnoreCase(mep.getKey().name()))
    	    for (Z1_Seanse sean:   mep.getValue().getSeanse()){ 
    		 if(nameOfMovie.equalsIgnoreCase(sean.getMovie().getTitle())&& hour==sean.getStartTime().getHour()&& min==sean.getStartTime().getMin()){
    		 mep.getValue().removeSeanse(new Z1_Seanse(new Z1_Movie(sean.getMovie().getTitle(),sean.getMovie().getDuration()),
    		 new Z1_Time(sean.getStartTime().getHour(),sean.getStartTime().getMin())));}
    		 }
    	  }Z1_Cinema.showAllSeanses();
    	}catch(ConcurrentModificationException e){}
   }
    
  /**
   * 
   * container for remove movie ;
   * 
   * */
    
    
   /**
    * 
    * method for remove movie;
    * 
    * */

    void removeMovie(){
    	String title = inputNameOfMovieFromScanner();
		Iterator<Entry<Z1_Days, Z1_Schedule>> iterator = daysAndMovie.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Z1_Days, Z1_Schedule> entry = iterator.next();
				Set<Z1_Seanse> seanses = entry.getValue().getSeanse();
				Iterator<Z1_Seanse> iter = seanses.iterator();
				while (iter.hasNext()) {
				Z1_Seanse seanse = iter.next();
				if (seanse.getMovie().getTitle().equalsIgnoreCase(title)) 
				iter.remove();}}Z1_Cinema.showAllSeanses();
	}
}    	
