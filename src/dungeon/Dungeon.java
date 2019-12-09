package dungeon;
import java.util.Scanner;

public class Dungeon {

	public static void main(String[] args) {
		HeroFactory hFactory = new HeroFactory();
		MonsterFactory mFactory = new MonsterFactory();
		DungeonCharacter hero, monster;
		//DEVMODE
		//devMode();
		Scanner kb = new Scanner(System.in);
		do {
			int choice = 3;
			printMenu();
			choice = Keyboard.kbChoose(kb,3);
			hero = hFactory.createHero(convertChoice(choice));
			((Hero)hero).readName(kb);
			MazeMaker theMaze = new MazeMaker(hero);
			
			//Prep is done
			printWelcome(hero);
			System.out.println();
			System.out.println("Thunder crashes!!");
			mainMenu(hero, kb, theMaze);
			System.exit(10);
		} while (playAgain(kb));
		kb.close();
		
		
	}

	public static void mainMenu(DungeonCharacter hero, Scanner kb,MazeMaker theMaze) 
	{
		mainStage(hero);
		int mchoice = mainChoice(hero,kb);
		if(mchoice == 1)
		{
			moveMenu(theMaze,hero,kb);
		}
		//battle(hero, monster, kb);
		
	}

	private static void moveMenu(MazeMaker maze, DungeonCharacter hero, Scanner kb) 
	{
		int choice;
		do 
		{

			System.out.println("What door do you want to try to enter?");
			System.out.println("1. N");
			System.out.println("2. S");
			System.out.println("3. W");
			System.out.println("4. E");
			
			choice = kb.nextInt();
			
			if(validMove(maze,choice,hero) == false)
			{
				System.out.println("The door is actually a wall!");
			}
		}
		while (!validMove(maze,choice,hero));
		
	}

	private static boolean validMove(MazeMaker maze, int choice, DungeonCharacter hero) 
	{
		int[] location = hero.getLoc();
		if(choice == 1)
		{
			if(location[0] -1 < 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		if(choice == 2)
		{
			if(location[0] + 1 > 4)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		if(choice == 3)
		{
			if(location[1] -1 < 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		if(choice == 1)
		{
			if(location[1] + 1 > 4)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		return false;
	}

	private static void mainStage(DungeonCharacter hero)
	{
		System.out.print("Your hero is currently at ");
		hero.pingloc();
	}
	
	private static int mainChoice(DungeonCharacter hero,Scanner kb)
	{
		int choice;
		System.out.println("What do you choose to do hero?");
		do {
			System.out.println("1. Move Room");
			System.out.println("2. Use Item");
			System.out.println("3. Give up");
			choice=kb.nextInt();
		}
		while (choice<0 || choice>5);
		return choice;
	}
	
	//TO BE USED ONLY FOR DEV TESTING CERTAIN METHODS
	private static void devMode()
	{
		DungeonCharacter hero;
		HeroFactory hFactory = new HeroFactory();
		hero = hFactory.createHero(convertChoice(1));
		MazeMaker theMaze = new MazeMaker(hero);
		theMaze.printDungeon();
		System.exit(0);
	}
	
	private static void printWelcome(DungeonCharacter hero)
	{
		System.out.println(" WELCOME CHALLENGER " + hero.getName() + " to my labyrynthfh"
				+ " \n in order to escape you must traverse through my 5 x 5 maze"
				+"\n but there is a trick the only way to open my exit is by first collecting 4 pillars of OO hidden throughout the maze"
				+"\n however the road will not be easy there are monsters, but also items to help you along the way"
				+"\n here is a quick rundown of the different items that can appear in any room"
				+"\n M - Multiple Items \n P - Pit \n I - Entrance (In) \n O - Exit (Out) \n V - Vision Potion \n H - Healing Potion \n E - Empty Room \n X - Monster  ");
		
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
