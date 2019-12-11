package dungeon;

public class Kris implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " stabs a kris at " + opponent.getName() + ".");
		baseAttack(self, opponent, 15, 30, .8);
	}
	
	public String toString() {
		return "Kris";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Kris)
			return true;
		return false;
	}
}
