package dungeon;

public class HeroFactory {
	
	public Hero createHero(String type, AttackFactory attackFactory) {
		Hero hero = null;
		
			switch (type) {
		case "warrior":
			hero = new Warrior(attackFactory);
			break;
		case "sorceress":
			hero = new Sorceress(attackFactory);
			break;
		case "thief":
			hero = new Thief(attackFactory);
			break;
		}
		return hero;
	}

}
