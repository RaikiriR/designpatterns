package dungeon;
import java.util.*;

public class DungeonAdventure {
	static HeroFactory hFactory = new HeroFactory();
	static AttackFactory attackFactory = new AttackFactory();

	public static void main(String[] args) {
		List<Dungeon.Memento> savedStates = new ArrayList<Dungeon.Memento>();
		boolean devmode = false;
		
		DungeonCharacter hero;
		Scanner kb = new Scanner(System.in);
		do {
			int choice = 3;
			printMenu();
			choice = Keyboard.kbChoose(kb,5);
			hero = hFactory.createHero(convertChoice(choice), attackFactory);
			((Hero)hero).readName(kb);
			Dungeon theMaze = new Dungeon(hero);
			
			theMaze.setDungeon(theMaze);
			savedStates.add(theMaze.createMemento());
			
			devmode = printWelcome(hero, kb);
			System.out.println();
			System.out.println("Thunder crashes!!");
			System.out.println();
			mainMenu(hero, savedStates, kb, theMaze, devmode);
		} while (playAgain(kb));
		System.out.println("Exiting...");
		kb.close();
	}
	
	private static void printMenu() {
		System.out.println("Choose a hero: \n" + 
							"1. Warrior \n" + 
							"2. Sorceress \n" + 
							"3. Thief \n" +
							"4. Knight \n" +
							"5. Wizard");
	}

	public static void mainMenu(DungeonCharacter hero, List list, Scanner kb, Dungeon theMaze, boolean devmode) {
		boolean finishgame = false;
		boolean startgame = true;
		while(finishgame == false) {
			if(devmode == true)
				theMaze.printDungeon();
			else if(startgame == true) {
				theMaze.printRoom(((Hero)hero).getLoc());
				startgame = false;
			}
			System.out.println();
			System.out.println(((Hero)hero).toString());
			int mchoice = mainChoice(hero,kb);
			if(mchoice == 1)
				finishgame = moveMenu(theMaze, hero, kb);
			if(mchoice == 2)
				potionMenu(hero, theMaze, kb);
			if(mchoice == 3)
				gameState(3);
			if(mchoice == 4) {
				theMaze.setDungeon(theMaze);
				Dungeon.Memento mem = theMaze.createMemento();
				mem.save(theMaze);
				list.add(mem);
			}
			if(mchoice == 5) {
				theMaze = ((Dungeon.Memento)list.get(list.size()-1)).load();
				hero = theMaze.getHero();
				theMaze.printRoom(((Hero)hero).getLoc());
			}
			if(!hero.isAlive()) {
				finishgame = true;
				theMaze.printDungeon();
			}
		}
	}

	private static void potionMenu(DungeonCharacter hero, Dungeon theMaze, Scanner kb) {
		System.out.println("1. Use Healing Potion");
		System.out.println("2. Use Vision Potion");
		
		switch(kb.nextInt()) {
		case 1:
			if(((Hero)hero).getHealPot() > 0)
				((Hero)hero).useHealPot();
			break;
		case 2:
			if(((Hero)hero).getVisPot() > 0)
				((Hero)hero).useVisPot(theMaze);
			break;
		default:
		}
	}

	private static void gameState(int i) {
		if(i == 3)
			System.out.println("Exiting...");
			System.exit(10);
	}

	private static boolean moveMenu(Dungeon maze, DungeonCharacter hero, Scanner kb) {
		int choice;
		do {
			System.out.println("What door do you want to try to enter?");
			System.out.println("1. N");
			System.out.println("2. S");
			System.out.println("3. W");
			System.out.println("4. E");
			
			choice = kb.nextInt();
			
			if(validMove(choice, hero) == false)
				System.out.println("The door is actually a wall!");
		} while (!validMove(choice, hero));
		confirmChoice(hero, choice, maze);
		maze.printRoom(((Hero)hero).getLoc());
		return maze.roomStep(hero, attackFactory, kb);
	}

	private static void confirmChoice(DungeonCharacter hero, int choice, Dungeon maze) {
		int[] newloc = ((Hero)hero).getLoc();
		int row = newloc[0];
		int col = newloc[1];
		maze.lastHero(row,col);
		switch(choice) {
		case 1:
			row = row - 1;
			break;
		case 2:
			row = row + 1;
			break;
		case 3:
			col = col - 1;
			break;
		case 4:
			col = col + 1;
			break;
		}
		((Hero)hero).setLoc(row, col);
		maze.getRoom(row, col).spawnHero();
	}

	private static boolean validMove(int choice, DungeonCharacter hero) {
		int[] location = ((Hero)hero).getLoc();
		if(choice == 1) {
			if(location[0] - 1 < 0)
				return false;
			else
				return true;
		}
		if(choice == 2) {
			if(location[0] + 1 > 4)
				return false;
			else
				return true;
		}
		if(choice == 3) {
			if(location[1] - 1 < 0)
				return false;
			else
				return true;
		}
		if(choice == 4) {
			if(location[1] + 1 > 4)
				return false;
			else
				return true;
		}
		return false;
	}
	
	private static int mainChoice(DungeonCharacter hero, Scanner kb) {
		int choice;
		
		System.out.println("What do you choose to do hero?");
		do {
			System.out.println("1. Move Room");
			System.out.println("2. Use Item");
			System.out.println("3. Give up");
			System.out.println("4. Save Game");
			System.out.println("5. Load Game");
			choice = kb.nextInt();
		} while (choice < 0 || choice > 5);
		return choice;
	}
	
	private static boolean printWelcome(DungeonCharacter hero, Scanner kb) {
		System.out.println();
		System.out.println("Welcome challenger " + hero.getName() + " to my labyrinth.\n"
							+"In order to escape you must traverse through my maze.\n"
							+"But there is a trick!\n"
							+"The only way to open the exit is by first collecting the 4 Pillars of OO hidden throughout the maze.\n"
							+"However, the road will not be easy.\n"
							+"There are terrible monsters and fiendish traps, but also items to help you along the way.\n"
							+"Here is a quick rundown of the different items that can appear in any room.\n"
							+"M - Multiple Items\n"
							+"P - Pit\n"
							+"I - Entrance (In)\n"
							+"O - Exit (Out)\n"
							+"V - Vision Potion\n"
							+"H - Healing Potion\n"
							+"E - Empty Room\n"
							+"X - Monster\n"
							+"Enter anything to continue...");
		
		String x = kb.next();
		if(x.contentEquals("dev1"))
			return true;
		else
			return false;
	}
	
	private static boolean playAgain(Scanner scanner) {
		String input = "n";
		System.out.println("Play again (y/n)?");
		if (scanner.hasNext())
			input = scanner.next();
		return input.equalsIgnoreCase("y");
	}

	private static String convertChoice(int choice) {
		switch (choice) {
		case 1:
			return "warrior";
		case 2:
			return "sorceress";
		case 3:
			return "thief";
		case 4:
			return "knight";
		case 5:
			return "wizard";
		default:
			System.out.println("Invalid Choice, returning thief.");
			return "thief";
		}
	}
}