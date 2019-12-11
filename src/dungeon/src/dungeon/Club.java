package dungeon;

public class Club implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " slowly swings a club toward " + opponent.getName() + ".");
		baseAttack(self, opponent, 30, 60, .6);
	}
	
	public String toString() {
		return "Club";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Club)
			return true;
		return false;
	}
}

