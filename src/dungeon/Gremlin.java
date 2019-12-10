package dungeon;

public class Gremlin extends Monster {

	 public Gremlin(AttackFactory attackFactory) {
			super("Gnarltooth the Gremlin", 70, 5, "Fireball", .4, 20, 40, attackFactory);
	    }

		public void attack(DungeonCharacter opponent) {
			System.out.println(name + " jabs his kris at " + opponent.getName() + ":");
			super.attack.attack(this, opponent);
		}
		
}
