package EaDal;

public class rank {
	public int rank;
	public String rankType;
	
	public void print()
	{
		System.out.println(String.format("Rank (%s): %d", rankType, rank));
	}
}
