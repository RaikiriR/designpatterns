package dungeon;

public class Ogre extends Monster {

    public Ogre(AttackFactory attackFactory) {
		super("Oscar the Ogre", 200, 2, "Club", .1, 30, 60, attackFactory);
    }
}
