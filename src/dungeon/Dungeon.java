package dungeon;
import java.util.Scanner;

public class Dungeon {

	public static void main(String[] args) {
		HeroFactory hFactory = new HeroFactory();
		MonsterFactory mFactory = new MonsterFactory();
		DungeonCharacter hero, monster;
		MazeMaker theMaze = new MazeMaker();
		//DEVMODE
		devMode();
		Scanner kb = new Scanner(System.in);
		do {
			int choice = 3;
			printMenu();
			choice = Keyboard.kbChoose(kb,3);
			hero = hFactory.createHero(convertChoice(choice));
			((Hero)hero).readName(kb);
			System.out.println();
			monster = mFactory.createMonster();
			battle(hero, monster, kb);
		} while (playAgain(kb));
		kb.close();
		
		
	}

	//TO BE USED ONLY FOR DEV TESTING CERTAIN METHODS
	public static void devMode()
	{
		MazeMaker theMaze = new MazeMaker();
		theMaze.rollForHero();
		System.out.close();
	}
	
	private static void battle(DungeonCharacter hero, DungeonCharacter monster, Scanner kb) {
			String pause = "p";
			System.out.println(hero.getName() + " battles " + monster.getName());
			System.out.println("---------------------------------------------");
			
			while (hero.isAlive() && monster.isAlive()) {
				hero.battleChoices(monster, kb);
				if (monster.isAlive())
				    monster.attack(hero);
				if(pause.equalsIgnoreCase("q")) {
					pause = kb.next();
				}
				    		
				System.out.println("-->q to quit, anything else to continue: ");
				pause = kb.next();
				if(pause.equalsIgnoreCase("q")) {
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

	private static void printMenu() {
		System.out.println("Choose a hero: \n" + 
							"1. Warrior \n" + 
							"2. Sorceress \n" + 
							"3. Thief");
	}
	
	private static String convertChoice(int choice) {
		switch (choice) {
		case 1:
			return "warrior";
		case 2:
			return "sorceress";
		case 3:
			return "thief";
		default:
			System.out.println("Invalid Choice, returning thief.");
			return "thief";
		}
	}
}
