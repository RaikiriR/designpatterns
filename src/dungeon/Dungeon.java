package dungeon;
import java.util.Scanner;

public class Dungeon {

	public static void main(String[] args) {
		HeroFactory hFactory = new HeroFactory();
		MonsterFactory mFactory = new MonsterFactory();
		DungeonCharacter hero, monster;
		Scanner kb = new Scanner(System.in);
		do {
			int choice = 3;
			printMenu();
			choice = kbChoose(kb,3);
			hero = hFactory.createHero(convertChoice(choice));
			((Hero)hero).readName(kb);
			System.out.println();
			monster = mFactory.createMonster();
			battle(hero, monster, kb);
		} while (playAgain(kb));
		kb.close();
	}

	private static void battle(DungeonCharacter hero, DungeonCharacter monster, Scanner kb) {
			String pause = "p";
			System.out.println(hero.getName() + " battles " + monster.getName());
			System.out.println("---------------------------------------------");
			
			while (hero.isAlive() && monster.isAlive()) {
				hero.battleChoices(monster, kb);
				if (monster.isAlive())
				    monster.attack(hero);
				if(pause.equalsIgnoreCase("q"))
				{
					pause = kb.next();
				}
				    		
				System.out.println("-->q to quit, anything else to continue: ");
				pause = kb.next();
				if(pause.equalsIgnoreCase("q"))
				{
					System.out.println("Quitters never win ;-)");
					System.exit(0);
				}
			}

			if (!(monster.isAlive()))
			    System.out.println(hero.getName() + " was victorious!");
			else if (!(hero.isAlive()))
				System.out.println(hero.getName() + " was defeated :-(");
			
	}
	
	private static boolean playAgain(Scanner scanner) {
		String input = "n";
		System.out.println("Play again (y/n)?");
		if (scanner.hasNext())
			input = scanner.next();
		return input.equalsIgnoreCase("y");
	}

	
	public static int kbChoose(Scanner kb, int highchoice)
	{
		int choice = 0;
		while((choice < 1 || choice > highchoice))
		{
			if(kb.hasNextInt())
			{
				choice = kb.nextInt();
				if((choice > highchoice || choice < 1))
				{
					System.out.println("Error Try Again");
					kb.nextLine();
				}
			}
			else
			{
				System.out.println("Error Try Again");
				kb.next();
			}

		}
		return choice;
	}

	private static void printMenu()
	{
		System.out.println("Choose a hero: \n" + "1. Warrior \n" + "2. Sorceress \n" + "3. Thief");
	}
	private static String convertChoice(int choice)
	{
		if(choice == 1)
		{
			return "warrior";
		}
		if(choice == 2)
		{
			return "sorceress";
		}
		if(choice == 3)
		{
			return "thief";
		}
		return null;
	}
}
