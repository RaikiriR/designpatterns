package dungeon;

import java.util.Random;

public class MazeMaker {

	private Maze[][] maze;
	private DungeonCharacter hero;
	private int row = 5;
	private int col = 5;
	
	public MazeMaker(DungeonCharacter hero)
	{
		setMaze(getSpecs(1),getSpecs(2));
		spawnPillars(4);
		setExit();
		spawnHero(hero,maze);
		
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
				maze[r][c]=new Maze(r,c);
			}
		}
		return maze;
	}
	
	public void spawnPillars(int pillars)
	{
		maze[2][2].spawnInstance("Pillar");
		maze[2][3].spawnInstance("Pillar");
		maze[2][4].spawnInstance("Pillar");
		maze[2][1].spawnInstance("Pillar");
	}
	
	private void setExit()
	{
		maze[4][4].spawnInstance("Exit");
	}
	
	public void spawnHero(DungeonCharacter hero,Maze[][] maze)
	{
		boolean passtest = false;
		int row = 1;
		int col = 0;
		/*while(passtest == false)
		{
			row = rollFor(0,4);
			col = rollFor(0,4);
			passtest = checkRoom(row,col);
		}
		*/
		maze[row][col].spawnInstance("Hero");
		hero.setLoc(row, col);
		System.out.print("Hero set, pinging for location ");
	}
	
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}
	
	public Hero getHero(Hero hero)
	{
		return hero;
	}
	
	public int rollFor(int min, int max)
	{
			int result = randomRoller(min,max);
			return result;
		
	}
	
	public boolean checkRoom(int row, int col)
	{
		if(maze[row][col].getFill() == false)
		{
			return true;
		}
		return false;
	}
	
	public int randomRoller(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min)+1) + min;
		return randomNum;
	}
	
	public void checkMaze(MazeMaker maze)
	{
		Maze[][] mazer = this.maze;
		int count = 0;
		for(int r=0; r <this.row; r++)
		{
			for(int c=0; c<this.col;c++)
			{
				mazer[r][c].pingloc();
				System.out.println(mazer[r][c].getItem());
				count++;
			}
		}
		System.out.println("Total Count of rooms - " + count);
	}
	
	public void printDungeon()
    {
		Maze[][] mazer = this.maze;
		for(int r=0;r<5;r++)
        {
            String[] rows=new String[3];
            rows[0]="";
            rows[1]="";
            rows[2]="";
            
            
            //Creating 5 modules of 3 line rooms
            for(int c=0;c<5;c++)
            {
                  String[] row=mazer[r][c].toString().split("@");
                  rows[0]+=row[0];
                  rows[1]+=row[1];
                  rows[2]+=row[2];
            }
            
            //Printing 3 lines = 1 row
            for(int l=0;l<3;l++)
            {
                System.out.println(rows[l]);
            }
        }
		
		
    }
}
