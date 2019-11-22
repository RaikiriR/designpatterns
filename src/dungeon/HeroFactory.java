package dungeon;

import java.util.Scanner;

public class HeroFactory {
	
	public Hero createHero(Scanner kb) {
		Hero hero = null;
		int choice = 1;
		System.out.println("Choose a hero:\n" +
							"1. Warrior\n" +
							"2. Sorceress\n" +
							"3. Thief");
		if (kb.hasNextInt())
			choice = kb.nextInt();
		while (!(choice > 0 && choice < 4))
		{
			System.out.println("Wrong choice");
			if (kb.hasNextInt())
				choice = kb.nextInt();
		}
			switch (choice) {
		case 1:
			hero = new Warrior();
			break;
		case 2:
			hero = new Sorceress();
			break;
		case 3:
			hero = new Thief();
			break;
		}
		return hero;
	}
	
}
