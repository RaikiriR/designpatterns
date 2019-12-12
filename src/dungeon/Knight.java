package dungeon;

public class Knight extends Hero {

	public Knight(AttackFactory attackFactory) {
		super("Knight", 150, 2, "Spear", .4, attackFactory, "Healing Word");
	}

}