package dungeon;

public class Fireball implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		System.out.println(self.getName() + " lobs a fireball at " + opponent.getName() + ".");
		baseAttack(self, opponent, 25, 45, .7);
	}
	
	public String toString() {
		return "Fireball";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Fireball)
			return true;
		return false;
	}
}
