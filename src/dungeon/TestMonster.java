package dungeon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMonster {

	DungeonCharacter monster;
	MonsterFactory mFactory = new MonsterFactory();
	AttackFactory attackFactory = new AttackFactory();

	
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
	void healMonster() {
		monster = mFactory.createMonster(attackFactory);
		int hp1 = monster.getHealth();
		monster.heal(2);
		int hp2 = monster.getHealth();
		assertNotSame(hp1,hp2);
		
	}
	@Test
	void healNegative()
	{
		monster = mFactory.createMonster(attackFactory);
		int hp1 = monster.getHealth();
		monster.heal(-2);
		int hp2 = monster.getHealth();
		assertEquals(hp1,hp2);
	}

	
	
	@Test
	void killMonster()
	{
		monster = mFactory.createMonster(attackFactory);
		monster.damage(1000000);
		assertEquals(false,monster.isAlive());
	}
	
	@Test
	void noKillMonster()
	{
		monster = mFactory.createMonster(attackFactory);
		monster.damage(1);
		assertEquals(true,monster.isAlive());
	}
	
	@Test
	void damageMonster()
	{
		monster = mFactory.createMonster(attackFactory);
		int hp1 = monster.getHealth();
		monster.damage(1);
		int hp2 = monster.getHealth();
		assertNotSame(hp1,hp2);
	}
	
	
}
