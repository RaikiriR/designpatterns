package dungeon;

import java.util.Scanner;

public class Thief extends Hero {

	public Thief() {
		super("Thief", 75, 6, 20, 40, .8, .4);
	}

	public void surpriseAttack(DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + 
								name + " gets an additional turn.");
			turns ++;
			attack(opponent);
		} else if (surprise >= .8) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and blocked your attack!");
			System.out.println();
		} else
		    attack(opponent);
	}

    public void battleChoices(DungeonCharacter opponent, Scanner kb) {
		super.battleChoices(opponent, kb);
		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    int choice = 1;
		    kbchoose(kb,1);
		    switch (choice) {
			    case 1: 
			    	attack(opponent);
			        break;
			    case 2: 
			    	surpriseAttack(opponent);
			        break;
		    }
		    kb.nextLine();
			turns --;
		    if (turns > 0)
			    System.out.println("Number of turns remaining is: " + turns);
		} while (turns > 0 && opponent.getHealth() > 0);
    }

    public int kbchoose(Scanner kb, int choice)
	{
		if(kb.hasNextInt())
		{
			choice = kb.nextInt();
			if(choice < 0 || choice > 3)
			{
				System.out.println("Invalid choice given, auto choosing 1");
				choice = 1;
			}
			return choice;
		}
		else
		{
			System.out.println("Invalid choice given, auto choosing 1");
			return choice;
		}
	}
}
