package dungeon;

import java.util.Scanner;

public class Thief extends Hero {

	public Thief(AttackFactory attackFactory) {
		super("Thief", 75, 6, "Fireball", .4, attackFactory);
	}

	public void surpriseAttack(DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + 
								name + " gets an additional turn.");
			turns ++;
			System.out.println();
			attack(opponent);
		} else if (surprise >= .8) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and blocked your attack!");
			System.out.println();
		} else {
			System.out.println("Surprise attack failed.");
		    attack(opponent);
		}
	}
	
	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " throws a dagger at " + opponent.getName() + ":");
		super.attack.attack(this, opponent);
	}

    public void battleChoices(DungeonCharacter opponent, Scanner kb) {
		super.battleChoices(opponent, kb);
		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    
		    switch (Keyboard.kbChoose(kb,2)) {
			    case 1: 
			    	System.out.println();
			    	attack(opponent);
			        break;
			    case 2: 
			    	System.out.println();
			    	surpriseAttack(opponent);
			        break;
		    }
			turns --;
		    if (turns > 0)
			    System.out.println("Number of turns remaining is: " + turns);
		} while (turns > 0 && opponent.getHealth() > 0);
    }

}
