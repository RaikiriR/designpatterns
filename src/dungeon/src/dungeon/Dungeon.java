package dungeon;

import java.util.Scanner;

public class Dungeon {

	private Room[][] maze;
	private int row = 5;
	private int col = 5;
	private MonsterFactory mFactory = new MonsterFactory();
	
	public Dungeon(DungeonCharacter hero) {
		setRoom(row, col);
		spawnHero(hero, maze);
	}
	
	public Room getRoom(int row, int col) {
		return maze[row][col];
	}
	
	public Room[][] setRoom(int row, int col) {
		maze = new Room[row][col];
		stepThrough(row, col, maze);
		return maze;
	}
	
	/*Initialize the rooms inside the maze */
	private Room[][] stepThrough(int row, int col, Room[][] maze) {
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				maze[r][c] = new Room(r,c);
			}
		}
		return maze;
	}
	
	public void spawnHero(DungeonCharacter hero, Room[][] maze) {
		int row = 0;
		int col = 0;
		maze[row][col].spawnHero();
		((Hero)hero).setLoc(row, col);
	}
	
	public void checkMaze(Dungeon maze) {
		Room[][] mazer = this.maze;
		int count = 0;
		for(int r = 0; r < this.row; r++) {
			for(int c = 0; c < this.col; c++) {
				System.out.println(mazer[r][c].getItem());
				count++;
			}
		}
		System.out.println("Total count of rooms - " + count);
	}
	
	public void printRoom(int[] loc) {
		System.out.println(maze[loc[0]][loc[1]].toString());
	}
	
	public void printDungeon() {
		Room[][] mazer = this.maze;
		for(int r = 0; r < 5; r++) {
            String[] rows = new String[3];
            rows[0] = "";
            rows[1] = "";
            rows[2] = "";
            
            //Creating 5 modules of 3 line rooms
            for(int c = 0; c < 5; c++) {
                  String[] row = mazer[r][c].toString().split("\n");
                  rows[0] += row[0];
                  rows[1] += row[1];
                  rows[2] += row[2];
            }

            //Printing 3 lines = 1 row
            for(int l = 0; l < 3; l++)
                System.out.println(rows[l]);
        }
    }
	
		
		
	public void vision(int row, int col) {
		Room[][] mazer = this.maze;
		int rowLow = calculateConstraint(row, col, "rowLow");
		int rowHigh = calculateConstraint(row, col, "rowHigh");
		int colLow = calculateConstraint(row, col, "colLow");
		int colHigh = calculateConstraint(row, col, "colHigh");
		for(int r = rowLow; r < rowHigh + 1; r++) {
            String[] vrows = new String[3];
            vrows[0] = "";
            vrows[1] = "";
            vrows[2] = "";
            
            //Creating 5 modules of 3 line rooms
            for(int c = colLow; c < colHigh + 1; c++) {
                  String[] vrow=mazer[r][c].toString().split("\n");
                  vrows[0] += vrow[0];
                  vrows[1] += vrow[1];
                  vrows[2] += vrow[2];
            }
            
            //Printing 3 lines = 1 row
            for(int l = 0; l < 3; l++)
                System.out.println(vrows[l]);
        }
    }
	
	private int calculateConstraint(int row, int col, String type) {
		if(type.equals("rowLow")) {
			if(row - 1 < 0)
				return 0;
			else
				return row - 1;
		}
		
		if(type.equals("rowHigh")) {
			if(row + 1 > 4)
				return 4;
			else
				return row + 1;
		}
		
		if(type.equals("colLow")) {
			if(col - 1 < 0)
				return 0;
			else
				return col - 1;
		}
		
		if(type.equals("colHigh")) {
			if(col + 1 > 4)
				return 4;
			else
				return col + 1;
		}
		
		return 0;
	}

	public boolean roomStep(DungeonCharacter heroIn, AttackFactory attackFactory, Scanner kb) {
		int[] locCheck = ((Hero)heroIn).getLoc();
		int row = locCheck[0];
		int col = locCheck[1];
		String items = maze[row][col].getItem();
		
		if(items.contains("X")) {
			DungeonCharacter monster = mFactory.createMonster(attackFactory);
			System.out.println(monster.getName() + " has been encountered. Prepare for battle!");
			while(heroIn.isAlive() && monster.isAlive()) {
				heroIn.battleChoices(monster, kb);
				if (monster.isAlive())
				    monster.attack.attack(monster, heroIn);
				if (!(monster.isAlive()))
				    System.out.println(heroIn.getName() + " was victorious!");
				else if (!(heroIn.isAlive()))
					System.out.println(heroIn.getName() + " was defeated.");
			}
			maze[row][col].removeItem("X");
		}
		
		if(items.contains("I")) {
			System.out.println("That is the entrance.");
		}
		
		if(items.contains("T")) {
			System.out.println("Congratulations! You have found a pillar of OO.");
			((Hero)heroIn).setPillarOO((((Hero)heroIn).getPillarOO() + 1));
			maze[row][col].removeItem("T");
		}
		
		if(items.contains("P")) {
			System.out.println("You have fallen in a pit and taken damage!");
			heroIn.damage((int)(Math.random() * 20) + 1);
			maze[row][col].removeItem("P");
		}
		
		if(items.contains("V")) {
			System.out.println("Vision potion obtained!");
			((Hero)heroIn).setVisPot((((Hero)heroIn).getVisPot() + 1));
			maze[row][col].removeItem("V");
		}
		
		if(items.contains("H")) {
			System.out.println("Healing potion obtained!");
			((Hero)heroIn).setHealPot((((Hero)heroIn).getHealPot() + 1));
			maze[row][col].removeItem("H");
		}
		
		if(items.contains("E")) {
			System.out.println("This is an empty room...");
		}
		
		if(items.contains("O")) {
			System.out.println("This is the exit"
							+"\n Do you have all the pillars needed?");
			if(((Hero)heroIn).getPillarOO() == 4) {
				System.out.println("You've escaped the maze!");
				return true;
			}
			
		}
		return false;
	}

	public void lastHero(int rowPrev, int colPrev) {
		if(maze[rowPrev][colPrev].getItem().contains("Y"))
			maze[rowPrev][colPrev].removeItem("Y");
	}
}
