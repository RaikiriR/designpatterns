package dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class TestHeroCreate {

	DungeonCharacter hero;
	HeroFactory hFactory = new HeroFactory();
	AttackFactory aFactory = new AttackFactory();

	@Test
	void testWarrior() {
		hero = hFactory.createHero("warrior", aFactory);
		assertEquals("Warrior has 125 HP, 0 healing potion(s), 0 vision potion(s), and 0 pillar(s) of OO.", ((Hero)hero).toString());
	}
	
	@Test
	void testSorceress() {
		hero = hFactory.createHero("sorceress", aFactory);
		assertEquals("Sorceress has 75 HP, 0 healing potion(s), 0 vision potion(s), and 0 pillar(s) of OO.", ((Hero)hero).toString());
	}
	
	@Test
	void testThief() {
		hero = hFactory.createHero("thief", aFactory);
		assertEquals("Thief has 75 HP, 0 healing potion(s), 0 vision potion(s), and 0 pillar(s) of OO.", ((Hero)hero).toString());
	}
	
	@Test
	void testKnight() {
		hero = hFactory.createHero("knight", aFactory);
		assertEquals("Knight has 150 HP, 0 healing potion(s), 0 vision potion(s), and 0 pillar(s) of OO.", ((Hero)hero).toString());
	}
	
	@Test
	void testWizard() {
		hero = hFactory.createHero("wizard", aFactory);
		assertEquals("Wizard has 60 HP, 0 healing potion(s), 0 vision potion(s), and 0 pillar(s) of OO.", ((Hero)hero).toString());
	}
	
	

}
