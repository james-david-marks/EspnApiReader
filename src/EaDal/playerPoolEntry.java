package EaDal;

public class playerPoolEntry {

	public int id;
	public player player;
	
	public void print()
	{
		System.out.println("id: " + id);
		player.print();
	}
	public void printPlayerRanks()
	{
		player.print();
	}
}
