package dungeon;

public class RustyBlade implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " slices a rusty blade at " + opponent.getName() + ".");
		baseAttack(self, opponent, 30, 50, .8);
	}
	
	public String toString() {
		return "RustyBlade";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof RustyBlade)
			return true;
		return false;
	}
}
