package dungeon;

import java.util.Random;

public class MazeMaker {

	private Room[][] maze;
	private DungeonCharacter hero;
	private int row = 5;
	private int col = 5;
	
	public MazeMaker(DungeonCharacter hero)
	{
		setRoom(getSpecs(1),getSpecs(2));
		spawnPillars(4);
		setExit();
		setEnter();
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
	
	public Room[][] setRoom(int row, int col)
	{
		maze = new Room[row][col];
		stepThrough(row,col,maze);
		return maze;
	}
	
	/*Initialize the rooms inside the maze */
	public Room[][] stepThrough(int row, int col, Room[][] maze)
	{
		for(int r=0; r <row; r++)
		{
			for(int c=0; c<col;c++)
			{
				maze[r][c]=new Room(r,c);
			}
		}
		return maze;
	}
	
	public void spawnPillars(int pillars)
	{
		maze[3][2].spawnInstance("Pillar");
		maze[2][3].spawnInstance("Pillar");
		maze[4][4].spawnInstance("Pillar");
		maze[1][4].spawnInstance("Pillar");
	}
	
	private void setExit()
	{
		maze[4][4].spawnInstance("Exit");
	}
	private void setEnter()
	{
		maze[0][0].spawnInstance("Enter");
	}
	
	public void spawnHero(DungeonCharacter hero,Room[][] maze)
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
		Room[][] mazer = this.maze;
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
		Room[][] mazer = this.maze;
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
	
		
		
	public void vizion(int row, int col)
    {
		Room[][] mazer = this.maze;
		int rowlow = calculateConstraint(row,col,"rowlow");
		int rowhigh = calculateConstraint(row,col,"rowhigh");
		int collow = calculateConstraint(row,col,"collow");
		int colhigh = calculateConstraint(row,col,"colhigh");
		for(int r=rowlow;r<rowhigh+1;r++)
        {
            String[] vrows=new String[3];
            vrows[0]="";
            vrows[1]="";
            vrows[2]="";
            
            
            //Creating 5 modules of 3 line rooms
            for(int c=collow;c<colhigh+1;c++)
            {
                  String[] vrow=mazer[r][c].toString().split("@");
                  vrows[0]+=vrow[0];
                  vrows[1]+=vrow[1];
                  vrows[2]+=vrow[2];
            }
            
            //Printing 3 lines = 1 row
            for(int l=0;l<3;l++)
            {
                System.out.println(vrows[l]);
            }
        }
	
    }
	
	private int calculateConstraint(int row, int col, String type)
	{
		if(type.equals("rowlow"))
		{
			if(row -1 < 0)
			{
				return 0;
			}
			else
			{
				return row-1;
			}
		}
		
		if(type.equals("rowhigh"))
		{
			if(row + 1 > 4)
			{
				return 4;
			}
			else
			{
				return row + 1;
			}
		}
		
		if(type.equals("collow"))
		{
			if(col-1 < 0)
			{
				return 0;
			}
			else
			{
				return col-1;
			}
		}
		if(type.equals("colhigh"))
		{
			if(col + 1 > 4)
			{
				return 4;
			}
			else
			{
				return col + 1;
			}
		}
		return 0;
	}

	public void roomStep(DungeonCharacter heroin) 
	{
		int[] loccheck = heroin.getLoc();
		int row = loccheck[0];
		int col = loccheck[1];
		String items = maze[row][col].getItem();
		if(items.contains("T"))
		{
			System.out.println("Congrats you have found a pillar of OO");
			maze[row][col].removeItem();

		}
		if(items.contains("P"))
		{
			System.out.println("You have fallen and taken damage!");
			maze[row][col].removeItem();

		}
		if(items.contains("I"))
		{
			System.out.println("That is the enterance");
			maze[row][col].removeItem();

		}
		if(items.contains("V"))
		{
			System.out.println("Vizion potion obtained!");
			maze[row][col].removeItem();

		}
		if(items.contains("H"))
		{
			System.out.println("Healing potion obtained!");
			maze[row][col].removeItem();

		}
		if(items.contains("E"))
		{
			System.out.println("This is an empty room...");

		}
		if(items.contains("X"))
		{
			System.out.println("..!\nA monster has been encountered, prepare for battle!");
			maze[row][col].removeItem();

		}
		if(items.contains("O"))
		{
			System.out.println("This is the exit\nDo you have all the pillars needed?");
			maze[row][col].removeItem();
		}
		if(maze[row][col].getItem().contentEquals("E"))
		{
			maze[row][col].removeItem();
			maze[row][col].removeItem();
			maze[row][col].spawnInstance("Hero");
		}

	}

	public void lastHero(int rowprev, int colprev, int rowcur, int colcur) 
	{
		if(maze[rowprev][colprev].getItem().contains("Y"))
		{
			maze[rowprev][colprev].removeItem();
		}
		maze[rowprev][colprev].removeItem();
	}
	
	public void test(int x, int y)
	{
		maze[x][y].removeItem();
	}
}
