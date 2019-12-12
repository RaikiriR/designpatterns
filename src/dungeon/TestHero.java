package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestHero {

	DungeonCharacter hero;
	HeroFactory hFactory = new HeroFactory();
	AttackFactory aFactory = new AttackFactory();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		hero = hFactory.createHero("warrior", aFactory);
		int hp1 = hero.getHealth();
		hero.heal(2);
		int hp2 = hero.getHealth();
		assertNotSame(hp1,hp2);
		
	}

	@Test
	void healNegative()
	{
		hero = hFactory.createHero("warrior", aFactory);
		int hp1 = hero.getHealth();
		hero.heal(-2);
		int hp2 = hero.getHealth();
		assertEquals(hp1,hp2);
	}

	
	
	@Test
	void killhero()
	{
		hero = hFactory.createHero("warrior", aFactory);
		hero.damage(1000000);
		assertEquals(false,hero.isAlive());
	}
	
	@Test
	void noKillhero()
	{
		hero = hFactory.createHero("warrior", aFactory);
		hero.damage(1);
		assertEquals(true,hero.isAlive());
	}
	
	
}
