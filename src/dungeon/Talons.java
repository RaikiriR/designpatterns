package dungeon;

public class Talons implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " slashes with natural talons at " + opponent.getName() + ".");
		baseAttack(self, opponent, 10, 20, .8);
	}
	
	public String toString() {
		return "Talons";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Talons)
			return true;
		return false;
	}
}