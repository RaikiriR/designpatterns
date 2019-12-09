package dungeon;

public class Maze {

	private String item;
	private int row;
	private int col;
	private boolean filled;
	public Maze(int row, int col, String string) 
	{
		setRow(row);
		setCol(col);
		
	}
	
	private void setCol(int setcol) 
	{
		this.col = setcol;
		
	}

	private void setRow(int setrow) 
	{
		this.row = setrow;
		
	}

	public void spawnInstance(String instance)
	{
		if(instance.contains("Exit"))
		{
			this.item = "E";
			this.filled = true;
		}
		if(instance.contains("Pillar"))
		{
			this.item = "P";
			this.filled = true;
		}
		
	}

	
}
