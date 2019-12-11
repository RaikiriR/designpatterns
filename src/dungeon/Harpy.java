package dungeon;

public class Harpy extends Monster {

    public Harpy(AttackFactory attackFactory) {
		super("Skrawk the Harpy", 50, 5, "Talons", .1, 10, 20, attackFactory);
    }
}