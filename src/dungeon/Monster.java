package dungeon;

public abstract class Monster extends DungeonCharacter {
	
	protected double chanceToHeal;
	protected int minHeal, maxHeal;

	public Monster(String name, int health, int speed, String attack, double chanceToHeal, int minHeal, int maxHeal, AttackFactory attackFactory) {
		super(name, health, speed, attack, attackFactory);
		this.chanceToHeal = chanceToHeal;
		this.minHeal = minHeal;
		this.maxHeal = maxHeal;
	}

  public void regenerate() {
	int healAmount;
	if ((Math.random() <= chanceToHeal) && (health > 0)) {
		healAmount = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		heal(healAmount);
	}
  }

 public void damage(int damageAmount) {
		super.damage(damageAmount);
		regenerate();
 }
 
}
