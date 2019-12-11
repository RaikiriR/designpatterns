package dungeon;

import java.util.Scanner;

public abstract class Hero extends DungeonCharacter {
	protected double blockChance;
	protected int turns;
	protected int healPot = 0;
	protected int visPot = 0;
	protected int pillarOO = 0;
	protected Attack spAttack;
	private int[] loc;
	
	public Hero(String name, int health, int speed, String attack, double blockChance, AttackFactory attackFactory, String spAttack) {
		super(name, health, speed, attack, attackFactory);
		this.blockChance = blockChance;
		this.spAttack = attackFactory.getAttack(spAttack);
	}
	
	public void addTurn() {
		this.turns ++;
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
		numTurns(opponent, kb);
		do {
			System.out.println("1. Attack Opponent");
		    System.out.println("2. " + spAttack.toString());
		    System.out.print("Choose an option: ");
		    
		    switch (Keyboard.kbChoose(kb,2)) {
			    case 1: 
			    	System.out.println();
			    	attack.attack(this, opponent);
			        break;
			    case 2: 
			    	System.out.println();
			    	spAttack.attack(this, opponent);
			        break;
			    default:
			        System.out.println("Invalid choice!");
		    }
			turns--;
			if (turns > 0)
			    System.out.println("Number of turns remaining is: " + turns);
		} while (turns > 0 && opponent.getHealth() > 0);
    }
    
	private void numTurns(DungeonCharacter opponent, Scanner kb) {
	    turns = getSpeed()/opponent.getSpeed();
		if (turns == 0)
			turns ++;
		System.out.println("Number of turns this round is: " + turns);
	}
	
	public void useHealPot() {
		super.heal((int)(Math.random() * 11) + 5);
		this.healPot--;
	}
	
	public void setHealPot(int number) {
		this.healPot = number;
	}
	
	public int getHealPot() {
		return this.healPot;
	}
	
	public void useVisPot(Dungeon dungeon) {
		dungeon.vision(loc[0], loc[1]);
		this.visPot--;
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
	
	public void setLoc(int row, int col) {
        int[] updateloc = new int[2];
        updateloc[0] = row;
        updateloc[1] = col;
        loc = updateloc;
    }
	
	public int[] getLoc() {
		return loc;
	}
	
	@Override
	public String toString() {
		return this.name + " has " + this.health + " HP, " + this.healPot + " healing potion(s), " + this.visPot + " vision potion(s), and " + this.pillarOO + " pillar(s) of OO.";
	}
}
