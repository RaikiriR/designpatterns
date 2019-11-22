package dungeon;

import java.util.Scanner;

public class Warrior extends Hero {

	public Warrior() {
		super("Warrior", 125, 4, 35, 60, .8, .2);
	}
	
	public void crushingBlow(DungeonCharacter opponent) {
		if (Math.random() <= .4) {
			int blowDamage = (int)(Math.random() * 76) + 100;
			System.out.println(name + " lands a CRUSHING BLOW for " + blowDamage + " damage!");
			opponent.damage(blowDamage);
		} else {
			System.out.println(name + " failed to land a crushing blow.");
			System.out.println();
		}
	}

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " swings a mighty sword at " + opponent.getName() + ":");
		super.attack(opponent);
	}

    public void battleChoices(DungeonCharacter opponent, Scanner kb) {
		super.battleChoices(opponent, kb);
		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");

		    switch (kb.nextInt()) {
			    case 1: 
			    	System.out.println();
			    	attack(opponent);
			        break;
			    case 2: 
			    	System.out.println();
			    	crushingBlow(opponent);
			        break;
			    default:
			        System.out.println("Invalid choice!");
		    }
			turns--;
			if (turns > 0)
			    System.out.println("Number of turns remaining is: " + turns);
		} while (turns > 0 && opponent.getHealth() > 0);
    }

}