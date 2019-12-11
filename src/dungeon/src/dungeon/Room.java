package dungeon;

public class Room {

	private String item = "";
	private int itemcount;
	private int[] loc = new int[2];
	private boolean filled;
	private boolean nDoor = true, sDoor = true, eDoor = true, wDoor = true;
	
	public Room(int row, int col) {
		loc[0] = row;
		loc[1] = col;
		setDoors();
		setItems();
		setPillars();
	}
	
	private void setDoors() {
		if(loc[0] == 0)
			nDoor = false;
		if(loc[0] == 4)
			sDoor = false;
		if(loc[1] == 0)
			wDoor = false;
		if(loc[1] == 4)
			eDoor = false;
	}
	
	private void setItems() {
		if (!nDoor && !wDoor) {
			this.item = "I";
			this.itemcount++;
			return;
		}
		if (!sDoor && !eDoor) {
			this.item = "O";
			this.itemcount++;
			return;
		}
		if (((int)(Math.random() * 100) + 1) < 11) {
			this.item += "H";
			this.itemcount++;
		}
		if (((int)(Math.random() * 100) + 1) < 11) {
			this.item += "V";
			this.itemcount++;
		}
		if (((int)(Math.random() * 100) + 1) < 11) {
			this.item += "P";
			this.itemcount++;
		}
		if (((int)(Math.random() * 100) + 1) < 26) {
			this.item += "X";
			this.itemcount++;
		}
	}
	
	private void setPillars() {
		if(loc[0] == 0 && loc[1] == 3) {
			this.item += "T";
			this.itemcount++;
		}
		if(loc[0] == 3 && loc[1] == 1) {
			this.item += "T";
			this.itemcount++;
		}
		if(loc[0] == 4 && loc[1] == 3) {
			this.item += "T";
			this.itemcount++;
		}
		if(loc[0] == 1 && loc[1] == 2) {
			this.item += "T";
			this.itemcount++;
		}
	}
	
	public void spawnHero() {
		this.item += "Y";
		this.itemcount++;
	}
	
	public boolean getFill() {
		return filled;
	}
	
	public String getItem() {
		if(this.item == null || this.item.isEmpty())
			return "E";
		return this.item;
	}

	public String toString() {
		String fill = "";
		if(this.item == null || this.item.isEmpty())
			fill = "E";
		else if (this.itemcount >= 2)
			fill = "M";
		else if(this.itemcount == 1)
			fill = this.item;

		String room = "";
		if (nDoor)
			room += "*-*\n";
		else
			room += "***\n";
		if(wDoor)
			room += "|" + fill;
		else
			room += "*" + fill;
		if(eDoor)
			room += "|\n";
		else
			room += "*\n";
		if(sDoor)
			room += "*-*";
		else
			room += "***";
		return room;
    }
	
	public void removeItem(String type) {
		if(this.item != null) {
			if(itemcount == 0) { 
			}
			else if(itemcount == 1 && this.item.equals(type)) {
				this.item = "";
				this.itemcount--;
				return;
			} else if(itemcount > 1) {
				if(item.indexOf(type) == 0) {
					this.item = item.substring(1);
					this.itemcount--;
				} else {
					this.item = stripElement(this.item, 0, this.item.indexOf(type), this.item.length() - 1);
					this.itemcount--;
				}
					
			}
		}
	}
	
	private String stripElement(String string, int start, int gap, int end) {
		String firstHalf = string.substring(start, gap);
		String secondHalf = string.substring(gap+1, end+1);
		return firstHalf + secondHalf;
	}
}
