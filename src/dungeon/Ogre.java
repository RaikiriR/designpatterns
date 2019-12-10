package dungeon;

public class Ogre extends Monster {

    public Ogre(AttackFactory attackFactory) {
		super("Oscar the Ogre", 200, 2, "Fireball", .1, 30, 60, attackFactory);
    }

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " slowly swings a club toward's " + opponent.getName() + ":");
		super.attack.attack(this, opponent);
	}

}
