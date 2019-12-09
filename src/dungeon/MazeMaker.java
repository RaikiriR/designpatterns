package dungeon;

import java.util.Random;

public class MazeMaker {

	private Maze[][] maze;
	private Hero hero;
	private int row = 5;
	private int col = 5;
	
	public MazeMaker()
	{
		setMaze(getSpecs(1),getSpecs(2));
		//spawnPillars(4);
		//setExit();
		//spawnHero(hero);
		
	}
	
	private int getSpecs(int choice)
	{
		if(choice == 1)
		{
			return row;
		}
		if(choice == 2)
		{
			return col;
		}
		return 0;
	}
	
	public Maze[][] setMaze(int row, int col)
	{
		maze = new Maze[row][col];
		stepThrough(row,col,maze);
		return maze;
	}
	
	/*Initialize the rooms inside the maze */
	public Maze[][] stepThrough(int row, int col, Maze[][] maze)
	{
		for(int r=0; r <row; r++)
		{
			for(int c=0; c<col;c++)
			{
				maze[r][c]=new Maze(r,c,"");
			}
		}
		return maze;
	}
	
	public void spawnPillars(int pillars)
	{
		maze[3][0].spawnInstance("Pillar");
	}
	
	private void setExit()
	{
		maze[2][0].spawnInstance("Exit");
	}
	
	private void spawnHero(Hero hero)
	{
		rollForHero();
	}
	
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}
	
	public Hero getHero(Hero hero)
	{
		return hero;
	}
	
	public void rollForHero()
	{
		int row = randomRoller(0,5);
		int col = randomRoller(0,5);
		System.out.println(row);
		System.out.println(col);

	}
	
	private int randomRoller(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min)+1) + min;
		return randomNum;
	}
}
