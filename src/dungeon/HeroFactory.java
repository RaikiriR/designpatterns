package dungeon;

public class HeroFactory {
	
	public Hero createHero(String type) {
		Hero hero = null;
		
			switch (type) {
		case "warrior":
			hero = new Warrior();
			break;
		case "sorceress":
			hero = new Sorceress();
			break;
		case "thief":
			hero = new Thief();
			break;
		}
		return hero;
	}

}
