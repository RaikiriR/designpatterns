package dungeon;

public class Skeleton extends Monster {
	
	   public Skeleton() {
			super("Sargath the Skeleton", 100, 3, 30, 50, .8, .3, 30, 50);
	    }

		public void attack(DungeonCharacter opponent)
		{
			System.out.println(name + " slices his rusty blade at " + opponent.getName() + ":");
			super.attack(opponent);
		}

}
