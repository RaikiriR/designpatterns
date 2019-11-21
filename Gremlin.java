package dungeon;

public class Gremlin extends Monster {

	 public Gremlin() {
			super("Gnarltooth the Gremlin", 70, 5, 15, 30, .8, .4, 20, 40);
	    }

		public void attack(DungeonCharacter opponent) {
			System.out.println(name + " jabs his kris at " + opponent.getName() + ":");
			super.attack(opponent);
		}
		
}
