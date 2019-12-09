package dungeon;

import java.util.Random;

public class Room {

	private String item;
	private int itemcount = 0;
	private int row;
	private int col;
	private boolean filled;
	public Room(int row, int col) 
	{

		setRow(row);
		setCol(col);
		setItem();
	}
	
	private void setItem() 
	{
			int type = rollItem(0,99);
			String spawned = spawnItem(type);
			updateItem(spawned);
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
		if(type < 20)
		{
			return "H";
		}
		if(type > 20 && type < 40)
		{
			return "X";
		}
		if(type > 40 && type < 50)
		{
			return "V";
		}
		if(type > 40 && type < 50)
		{
			return "V";
		}
		return null;
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
		if(this.item == null)
		{
			return "E";
		}
		else
		{
			return this.item;
		}
	}
	
	public void spawnInstance(String instance)
	{
		if(instance.contains("Exit"))
		{
			updateItem("O");
		}
		if(instance.contains("Pillar"))
		{
			updateItem("T");
		}
		if(instance.contains("Hero"))
		{
			updateItem("Y");
		}
		if(instance.contains("Enter"))
		{
			updateItem("I");
		}
	}

	private void updateItem(String newitem)
	{
	    if(this.col == 0 && this.row == 0)
	    {
	    	if(newitem != null)
	    	{
		    	if(newitem.contains("I"))
		    	{
		    		this.item = newitem;
		    	}
	    	}
	    }
	    else if(this.col == 4 && this.row == 4)
	    {
	    	if(newitem != null)
	    	{
		    	if(newitem.contains("O"))
		    	{
		    		this.item = newitem;
		    	}
	    	}
	    }
	    else if(newitem == null)
	    {
	    	
	    }
		else if(this.item == null)
		{
			this.item = newitem;
			this.filled = true;;
			this.itemcount++;
		}
		else if(itemcount < 3)
		{
			this.item = this.item + newitem;
			this.filled = true;
			this.itemcount++;
		}
	}
	
	public String toString()
    {
		String fill = "";
		if(this.item == null)
		{
			fill = "E";
		}
		else if (this.itemcount >= 2)
		{
			fill = "M";
		}
		else if(this.itemcount == 1)
		{
			fill = this.item;
		}

		
		//edges
		if(row==0)
		{
			if(col==0)
			{
				return "***" + "@*" + "I" + "|@" + "*-*";
			}
			else if(col==4)
			{
				return "***" + "@|" + fill + "*@" + "*-*";

			}
			else if((col>0 || col<4))
			{
				return "***" + "@|" + fill + "|@" + "*-*";
			}
			
		}
		
		//edges
		else if(row==4)
		{
			if(col==0)
			{
				return "*-*" + "@*" + fill + "|@" + "***";

			}
			
			if(col==4)
			{
				return "*-*" + "@|" + "O" +"*@" + "***";
			}
			else if((col>0 || col<4))
			{
				return "*-*" + "@|" + fill + "|@" + "***";

			}
		}
		
		//edges 
		else if(col == 0)
		{
			if((row>0 || row<4))
			{
				return "*-*" + "@*" + fill + "|@" + "*-*";
				
			}
		}
		
		//edges
		else if(col == 4)
		{
			if((row>0 || row<4))
			{
				return "*-*" + "@|" + fill + "*@" + "*-*";
			}
		}
		
		//middle
		else if((row>0 || row<4) && (col>0 || col<4))
		{
			return "*-*" + "@|" + fill + "|@" + "*-*";

		}

    	return "";
    }
	
	
}
