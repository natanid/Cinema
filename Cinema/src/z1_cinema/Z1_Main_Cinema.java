package z1_cinema;

import java.util.Scanner;

public class Z1_Main_Cinema {
	public static final Z1_Time OPENCINEMA = new Z1_Time(9, 00);
	public static final Z1_Time CLOSECINEMA = new Z1_Time(23, 00);
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		Z1_Cinema cinema = new Z1_Cinema();
		cinema.addDaysToMap();
		
		while (true) {
			System.out.println("enter 1 to add movie ");
			System.out.println("enter 2 to add seanse");
			System.out.println("enter 3 to remove movie");
			System.out.println("enter 4 to remove seanse");
            System.out.println("enter 5 for exit");
			String choice = Z1_Main_Cinema.scanner.next();

			switch (choice) {
			case "1":
				cinema.addMovie();
				break;
			case "2":
				cinema.addSeanses();
				break;
			case "3":
				cinema.removeMovie();
				break;
			case "4":
				cinema.removeSeanse();
				break;
			case "5":
				System.out.println("program exit");
				System.exit(0);
				break;
			case "6":
				break;
			case "7":
				break;
			}
		}
	}
}


