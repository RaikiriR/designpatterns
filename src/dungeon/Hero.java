package dungeon;

import java.util.Scanner;

public abstract class Hero extends DungeonCharacter {
	protected double blockChance;
	protected int turns;
	
	public Hero(String name, int health, int speed, int damageMin, int damageMax, double hitChance, double blockChance) {
		super(name, health, speed, damageMin, damageMax, hitChance);
		this.blockChance = blockChance;
	}
	
	public void readName(Scanner kb) {
		System.out.print("Enter character name: ");
		kb.nextLine();
		name = kb.next();
	}
	
	public void damage(int damageAmount) {
		if (Math.random() <= blockChance)
			System.out.println(name + " BLOCKED the attack!");
		else
			super.damage(damageAmount);
	}
	
	public void battleChoices(DungeonCharacter opponent, Scanner kb) {
	    turns = getSpeed()/opponent.getSpeed();
		if (turns == 0)
			turns ++;
		System.out.println("Number of turns this round is: " + turns);
	}
	
}
