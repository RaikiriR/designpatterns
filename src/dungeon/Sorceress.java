package dungeon;

import java.util.Scanner;

public class Sorceress extends Hero {
	
	private int minHeal = 25;
	private int maxHeal = 50;

	public Sorceress(AttackFactory attackFactory) {
		super("Sorceress", 75, 5, "Fireball", .3, attackFactory);
	}

	public void healingWord() {
		int healAmount = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		heal(healAmount);
    }

    public void battleChoices(DungeonCharacter opponent, Scanner kb) {
		super.battleChoices(opponent, kb);
		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Cast Healing Word");
		    System.out.print("Choose an option: ");
		    
		    switch (Keyboard.kbChoose(kb,2)) {
			    case 1: 
			    	System.out.println();
			    	attack.attack(this, opponent);
			        break;
			    case 2: 
			    	System.out.println();
			    	healingWord();
			        break;
		    }
			turns --;
		    if (turns > 0)
			    System.out.println("Number of turns remaining is: " + turns);
		} while (turns > 0 && opponent.getHealth() > 0);
    }
    

    
}
