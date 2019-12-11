package dungeon;

public class SneakAttack implements Attack {
	
	public void attack(DungeonCharacter self, DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + 
								self.getName() + " gets an additional turn.");
			((Hero)self).addTurn();
			System.out.println();
			self.attack.attack(self, opponent);
		} else if (surprise >= .8) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and blocked your attack!");
			System.out.println();
		} else {
			System.out.println("Surprise attack failed.");
			self.attack.attack(self, opponent);
		}
	}
	
	public String toString() {
		return "Sneak Attack";
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof SneakAttack)
			return true;
		return false;
	}
}