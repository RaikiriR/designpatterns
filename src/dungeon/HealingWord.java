package dungeon;

public class HealingWord implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
			System.out.println(self.getName() + " casts Healing Word.");
			self.heal((int)(Math.random() * 26) + 25);
	}
	
	public String toString() {
		return "Healing Word";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof HealingWord)
			return true;
		return false;
	}
}
