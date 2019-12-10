package dungeon;

import java.util.Scanner;

public abstract class Hero extends DungeonCharacter {
	protected double blockChance;
	protected int turns;
	protected int healPot = 0;
	protected int visPot = 0;
	protected int pillarOO = 0;
	protected Attack spAttack;
	
	public Hero(String name, int health, int speed, String attack, double blockChance, AttackFactory attackFactory, String spAttack) {
		super(name, health, speed, attack, attackFactory);
		this.blockChance = blockChance;
		this.spAttack = attackFactory.getAttack(spAttack);
	}
	
	public void readName(Scanner kb) {
		System.out.print("Enter character name: ");
		kb.nextLine();
		name = kb.next();
	}
	
	public void damage(int damageAmount) {
		if (Math.random() <= blockChance) {
			System.out.println(name + " BLOCKED the attack!");
			System.out.println();
		}
		else
			super.damage(damageAmount);
	}
	
	public void battleChoices(DungeonCharacter opponent, Scanner kb) {
	    turns = getSpeed()/opponent.getSpeed();
		if (turns == 0)
			turns ++;
		System.out.println("Number of turns this round is: " + turns);
	}
	
	public void setHealPot(int number) {
		this.healPot = number;
	}
	
	public int getHealPot() {
		return this.healPot;
	}
	
	public void setVisPot(int number) {
		this.visPot = number;
	}
	
	public int getVisPot() {
		return this.visPot;
	}
	
	public void setPillarOO(int number) {
		this.pillarOO = number;
	}
	
	public int getPillarOO() {
		return this.pillarOO;
	}
	
	@Override
	public String toString() {
		return this.name + "has " + this.health + " HP, " + this.healPot + " healing potions, " + this.visPot + " vision potions, and " + this.pillarOO + " pillars of OO.";
	}
}
