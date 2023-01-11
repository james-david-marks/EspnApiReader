package EaDal;

import com.google.gson.JsonObject;

public class team {
	int id;
	roster roster;
	
	public void print()
	{
		System.out.println("id: " + id);
		if(roster!=null)
		{
			roster.print();
		}
	}
	public void printTeamRosterRanks()
	{
		roster.printRanks();
	}
}
