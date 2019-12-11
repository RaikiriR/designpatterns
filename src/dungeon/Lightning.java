package dungeon;

public class Lightning implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " launches lightning towards " + opponent.getName() + ".");
		baseAttack(self, opponent, 50, 100, .6);
	}
	
	public String toString() {
		return "Lightning";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Lightning)
			return true;
		return false;
	}
}