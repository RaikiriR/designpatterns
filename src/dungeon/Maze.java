package dungeon;

import java.util.Random;

public class Maze {

	private String item;
	private int itemcount;
	private int row;
	private int col;
	private boolean filled;
	public Maze(int row, int col) 
	{

		setRow(row);
		setCol(col);
		setItem();
	}
	
	private void setItem() 
	{
		if(this.row == 0 && this.col == 0)
		{
			this.item = "H";
			this.filled = true;
		}
		else
		{
			int type = rollItem(0,99);
			String spawned = spawnItem(type);
			updateItem(spawned);
		}
	}

	private void setCol(int setcol) 
	{
		this.col = setcol;
		
	}

	public void pingloc()
	{
		System.out.print("Pinging --- ");
		System.out.print(row);
		System.out.print(" - ");
		System.out.print(col);
		System.out.print("  ");
	}
	
	private void setRow(int setrow) 
	{
		this.row = setrow;
		
	}
	
	private String spawnItem(int type)
	{
		if(type < 50)
		{
			return "P";
		}
		
		return " ";
	}
	
	private int rollItem(int min,int max)
	{
		int ans = randomRoller(min,max);
		return ans;
	}
	

	public int randomRoller(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min)+1) + min;
		return randomNum;
	}

	public boolean getFill()
	{
		return filled;
	}
	public String getItem()
	{
		return this.item;
	}
	
	public void spawnInstance(String instance)
	{
		if(instance.contains("Exit"))
		{
			updateItem("E");
		}
		if(instance.contains("Pillar"))
		{
			updateItem("X");
		}
		
	}

	private void updateItem(String newitem)
	{
		if(this.item == null)
		{
			this.item = newitem;
			this.filled = true;;
			this.itemcount++;
		}
		else
		{
			this.item = newitem;
			this.filled = true;
			this.itemcount++;
		}
	}
	
	public String toString()
    {
    	//designing room based on position
    	String roomdesign="";
    	roomdesign = createRoom(row,col);

    	return roomdesign;
    }
	
	private String createRoom(int r,int c)
	{
		//String fill = "";
		//if(itemcount =)
		String room = "|" + this.item + "|";
		return room;
	}
}
