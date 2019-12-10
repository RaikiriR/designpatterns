package dungeon;

import java.util.ArrayList;

public class AttackFactory {
	private ArrayList<Attack> attacks = new ArrayList<Attack>();
	
	public Attack getAttack(String attack) {
		switch (attack) {
		case "Fireball":
			if (attacks.isEmpty() || attacks.indexOf(new Fireball()) == -1) {
				Attack created = new Fireball();
				attacks.add(created);
				System.out.println(attacks.toString());
			}
			return attacks.get(attacks.indexOf(new Fireball()));
		case "Greatsword":
			if (attacks.isEmpty() || attacks.indexOf(new Greatsword()) == -1) {
				Attack created = new Greatsword();
				attacks.add(created);
				System.out.println(attacks.toString());
			}
			return attacks.get(attacks.indexOf(new Greatsword()));
		default:
			return null;
		}
	}

}
