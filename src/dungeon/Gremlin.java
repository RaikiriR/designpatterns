package dungeon;

public class Gremlin extends Monster {

	 public Gremlin(AttackFactory attackFactory) {
			super("Gnarltooth the Gremlin", 70, 5, "Kris", .4, 20, 40, attackFactory);
	    }

		public void attack(DungeonCharacter opponent) {
			super.attack.attack(this, opponent);
		}
		
}
