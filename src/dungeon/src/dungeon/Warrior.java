package dungeon;

public class Warrior extends Hero {

	public Warrior(AttackFactory attackFactory) {
		super("Warrior", 125, 4, "Greatsword", .2, attackFactory, "Crushing Blow");
	}

}
