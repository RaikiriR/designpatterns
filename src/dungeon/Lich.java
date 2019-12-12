package dungeon;

public class Lich extends Monster {

    public Lich(AttackFactory attackFactory) {
		super("Acererak the Lich", 100, 1, "Lightning", .6, 20, 40, attackFactory);
    }
}