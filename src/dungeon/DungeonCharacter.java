package dungeon;

import java.util.Scanner;

public abstract class DungeonCharacter {
	protected String name;
	protected int health;
	private int speed;
	private int damageMin, damageMax;
	private double hitChance;
	private int[] loc;
	
	public DungeonCharacter(String name, int health, int speed, int damageMin, int damageMax, double hitChance) {
		this.name = name;
		this.health = health;
		this.speed = speed;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.hitChance = hitChance;
	}
	
	public void attack(DungeonCharacter opponent) {
		if (Math.random() <= hitChance) {
			int damageAmount = (int)(Math.random() * (damageMax - damageMin + 1)) + damageMin ;
			opponent.damage(damageAmount);
		} else {
			System.out.println(name + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}
	}
	
	public void heal(int healAmount) {
		if (healAmount < 0)
			System.out.println("Cannot heal negative amounts.");
		else {
			health += healAmount;
			reportChange("heal", healAmount);
		}
	}
	
	public void damage(int damageAmount) {
		if (damageAmount < 0)
			System.out.println("Cannot damage negative amounts.");
		else {
			health -= damageAmount;
			if (health < 0)
				health = 0;
			reportChange("damage", damageAmount);
		}
	}
	
	private void reportChange(String type, int amount) {
		switch (type) {
		case "heal":
			System.out.println(name + " healed for [" + amount + "] points.\n" 
								+ "Total hit points remaining are: " + health);
			System.out.println();
			break;
		case "damage":
			System.out.println(name + " hit for <" + amount + "> points of damage.");
			System.out.println(name + " now has " + health + " hit points remaining.");
			System.out.println();
			if (health == 0)
				System.out.println(name + " has been killed.");
			break;
		}
	}
	
	public boolean isAlive() {
	  return health > 0;
	}

	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
	public int getSpeed() {
		return speed;
	}

	public void setLoc(int row, int col) {
        int[] updateloc = new int[2];
        updateloc[0] = row;
        updateloc[1] = col;
        loc = updateloc;
    }
	
	public int[] getLoc()
	{
		return loc;
	}
	
	public void pingloc()
	{
		System.out.print(loc[0]);
		System.out.print(" - ");
		System.out.print(loc[1]);
	}
	
	protected void battleChoices(DungeonCharacter monster, Scanner kb) {}
	
}
