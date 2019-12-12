package dungeon;

import java.io.Serializable;

public class Greatsword implements Attack, Serializable {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " swings a mighty sword at " + opponent.getName() + ".");
		baseAttack(self, opponent, 35, 60, .8);
	}
	
	public String toString() {
		return "Greatsword";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Greatsword)
			return true;
		return false;
	}
}
