package dungeon;

public class Spear implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " stabs a spear at " + opponent.getName() + ".");
		baseAttack(self, opponent, 25, 45, .75);
	}
	
	public String toString() {
		return "Spear";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Spear)
			return true;
		return false;
	}
}