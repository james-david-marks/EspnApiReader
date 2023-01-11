package EaDal;

public class ranking {
	
	public String rankingIndex;
	public rank[] ranks;
	
	public void print()
	{
		System.out.println("rankingIndex: " + rankingIndex);
		printArrayOfRank(ranks);
	}
	
	public void printArrayOfRank(rank[] ranks)
	{
		for(int i=0; i<ranks.length; i++)
		{
			ranks[i].print();
		}
	}
}
