package dungeon;

import java.io.Serializable;

public interface Attack extends Serializable {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent);

	public default void baseAttack(DungeonCharacter self, DungeonCharacter opponent, int damageMin, int damageMax, double hitChance) {
		if (Math.random() <= hitChance) {
			int damageAmount = (int)(Math.random() * (damageMax - damageMin + 1)) + damageMin;
			opponent.damage(damageAmount);
		} else {
			System.out.println(self.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}
	}
}
