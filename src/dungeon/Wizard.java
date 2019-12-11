package dungeon;

public class Wizard extends Hero {

	public Wizard(AttackFactory attackFactory) {
		super("Wizard", 60, 3, "Magic Missiles", .5, attackFactory, "Lightning");
	}  
}