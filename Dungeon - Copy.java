package dungeon;
import java.util.Scanner;

public class Dungeon {

	public static void main(String[] args) {
		HeroFactory hFactory = new HeroFactory();
		MonsterFactory mFactory = new MonsterFactory();
		DungeonCharacter hero, monster;
		Scanner kb = new Scanner(System.in);
		do {
			hero = hFactory.createHero(kb);
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

			while (hero.isAlive() && monster.isAlive() && !(pause.equalsIgnoreCase("q"))) {
				hero.battleChoices(monster, kb);
				if (monster.isAlive())
				    monster.attack(hero);
				
				System.out.println("-->q to quit, anything else to continue: ");
				pause = kb.next();
			}

			if (!(monster.isAlive()))
			    System.out.println(hero.getName() + " was victorious!");
			else if (!(hero.isAlive()))
				System.out.println(hero.getName() + " was defeated :-(");
			else
				System.out.println("Quitters never win ;-)");
	}
	
	private static boolean playAgain(Scanner scanner) {
		String input = "n";
		System.out.println("Play again (y/n)?");
		if (scanner.hasNext())
			input = scanner.next();
		return input.equalsIgnoreCase("y");
	}

}
