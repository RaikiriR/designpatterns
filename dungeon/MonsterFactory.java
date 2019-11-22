package dungeon;

public class MonsterFactory {
	Monster monster;
	
	public Monster createMonster() {
		Monster monster = null;
		int choice = (int)(Math.random() * 3) + 1;

		if (!(choice > 0 && choice < 4)) {
			System.out.println("Invalid Choice, Returning Skeleton.");
			choice = 3;
		}
			switch (choice) {
		case 1:
			monster = new Ogre();
			break;
		case 2:
			monster = new Gremlin();
			break;
		case 3:
			monster = new Skeleton();
			break;
		}
		return monster;
	}

}
