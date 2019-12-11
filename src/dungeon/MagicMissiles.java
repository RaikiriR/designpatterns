package dungeon;

public class MagicMissiles implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " launches an array of tiny magic missiles at " + opponent.getName() + ".");
		baseAttack(self, opponent, 15, 30, .99);
	}
	
	public String toString() {
		return "Magic Missiles";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof MagicMissiles)
			return true;
		return false;
	}
}