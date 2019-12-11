package dungeon;

public class CrushingBlow implements Attack {

	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
			System.out.println(self.getName() + " swings a mighty, crushing blow at " + opponent.getName());
			baseAttack(self, opponent, 75, 175, .4);
	}
	
	public String toString() {
		return "Crushing Blow";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof CrushingBlow)
			return true;
		return false;
	}
}
