package dungeon;

public class Thief extends Hero {

	public Thief(AttackFactory attackFactory) {
		super("Thief", 75, 6, "Dagger", .4, attackFactory, "Sneak Attack");
	}
}
