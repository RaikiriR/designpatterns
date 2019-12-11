package dungeon;

import java.util.ArrayList;

public class AttackFactory {
	private ArrayList<Attack> attacks = new ArrayList<Attack>();
	
	public Attack getAttack(String attack) {
		switch (attack) {
		
		case "Club":
			if (attacks.isEmpty() || attacks.indexOf(new Club()) == -1) {
				Attack created = new Club();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Club()));
			
		case "Crushing Blow":
			if (attacks.isEmpty() || attacks.indexOf(new CrushingBlow()) == -1) {
				Attack created = new CrushingBlow();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new CrushingBlow()));
			
		case "Dagger":
			if (attacks.isEmpty() || attacks.indexOf(new Dagger()) == -1) {
				Attack created = new Dagger();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Dagger()));
			
		case "Fireball":
			if (attacks.isEmpty() || attacks.indexOf(new Fireball()) == -1) {
				Attack created = new Fireball();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Fireball()));
			
		case "Greatsword":
			if (attacks.isEmpty() || attacks.indexOf(new Greatsword()) == -1) {
				Attack created = new Greatsword();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Greatsword()));
			
		case "Healing Word":
			if (attacks.isEmpty() || attacks.indexOf(new HealingWord()) == -1) {
				Attack created = new HealingWord();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new HealingWord()));
			
		case "Kris":
			if (attacks.isEmpty() || attacks.indexOf(new Kris()) == -1) {
				Attack created = new Kris();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Kris()));
			
		case "Lightning":
			if (attacks.isEmpty() || attacks.indexOf(new Lightning()) == -1) {
				Attack created = new Lightning();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Lightning()));
			
		case "Magic Missiles":
			if (attacks.isEmpty() || attacks.indexOf(new MagicMissiles()) == -1) {
				Attack created = new MagicMissiles();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new MagicMissiles()));
			
		case "Rusty Blade":
			if (attacks.isEmpty() || attacks.indexOf(new RustyBlade()) == -1) {
				Attack created = new RustyBlade();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new RustyBlade()));
			
		case "Sneak Attack":
			if (attacks.isEmpty() || attacks.indexOf(new SneakAttack()) == -1) {
				Attack created = new SneakAttack();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new SneakAttack()));
			
		case "Spear":
			if (attacks.isEmpty() || attacks.indexOf(new Spear()) == -1) {
				Attack created = new Spear();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Spear()));
			
		case "Talons":
			if (attacks.isEmpty() || attacks.indexOf(new Talons()) == -1) {
				Attack created = new Talons();
				attacks.add(created);
			}
			return attacks.get(attacks.indexOf(new Talons()));
		
		default:
			return null;
		}
	}
}
