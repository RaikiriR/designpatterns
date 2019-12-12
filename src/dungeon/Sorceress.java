package dungeon;

public class Sorceress extends Hero {

	public Sorceress(AttackFactory attackFactory) {
		super("Sorceress", 75, 5, "Fireball", .3, attackFactory, "Healing Word");
	}  
}
