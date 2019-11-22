package dungeon;

public class Ogre extends Monster {

    public Ogre() {
		super("Oscar the Ogre", 200, 2, 30, 60, .6, .1, 30, 60);
    }

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " slowly swings a club toward's " + opponent.getName() + ":");
		super.attack(opponent);
	}

}
