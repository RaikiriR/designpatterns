package dungeon;

import java.util.Scanner;

public class Keyboard {
	
	public static int kbChoose(Scanner kb, int highchoice) {
		int choice = 0;
		while((choice < 1 || choice > highchoice)) {
			if(kb.hasNextInt()) {
				choice = kb.nextInt();
				if((choice > highchoice || choice < 1)) {
					System.out.println("Error: Try Again");
					kb.next();
				}
			} else {
				System.out.println("Error: Try Again");
				kb.next();
			}
		}
		return choice;
	}
	
	

}
