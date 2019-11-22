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
		
		choice = kbchoose(kb, choice);
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
	
	public int kbchoose(Scanner kb, int choice)
	{
		if(kb.hasNextInt())
		{
			choice = kb.nextInt();
			if(choice < 0 || choice > 3)
			{
				System.out.println("Invalid choice given, auto creating warrior");
				choice = 1;
			}
			return choice;
		}
		else
		{
			System.out.println("Invalid choice given, auto creating warrior");
			return choice;
		}
	}

}
