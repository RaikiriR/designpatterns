package dungeon;

public class Skeleton extends Monster {
	
	   public Skeleton(AttackFactory attackFactory) {
			super("Sargath the Skeleton", 100, 3, "Fireball", .3, 30, 50, attackFactory);
	    }

		public void attack(DungeonCharacter opponent)
		{
			System.out.println(name + " slices his rusty blade at " + opponent.getName() + ":");
			super.attack.attack(this, opponent);
		}

}
