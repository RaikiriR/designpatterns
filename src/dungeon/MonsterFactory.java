package dungeon;

public class MonsterFactory {
	Monster monster;
	
	public Monster createMonster(AttackFactory attackFactory) {
		Monster monster = null;
		int choice = (int)(Math.random() * 5) + 1;

		if (!(choice > 0 && choice < 6)) {
			System.out.println("Invalid Choice, Returning Skeleton.");
			choice = 3;
		}
			switch (choice) {
		case 1:
			monster = new Ogre(attackFactory);
			break;
		case 2:
			monster = new Gremlin(attackFactory);
			break;
		case 3:
			monster = new Skeleton(attackFactory);
			break;
		case 4:
			monster = new Lich(attackFactory);
			break;
		case 5:
			monster = new Harpy(attackFactory);
			break;
		}
		return monster;
	}

}
