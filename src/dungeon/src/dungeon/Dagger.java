package dungeon;

public class Dagger implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " throws a dagger at " + opponent.getName() + ".");
		baseAttack(self, opponent, 20, 40, .8);
	}
	
	public String toString() {
		return "Dagger";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Dagger)
			return true;
		return false;
	}
}