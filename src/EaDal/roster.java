package EaDal;

import com.google.gson.JsonObject;

public class roster {

	double appliedStatTotal;
	rosterEntry[] entries;
	
	public void print()
	{
		System.out.println("appliedStatTotal: " + appliedStatTotal);
		if(entries!=null)
		{
			System.out.println("entries count: " + entries.length);
			printArrayOfRosterEntries(entries);
		}
	}
	public void printRanks()
	{
//		System.out.println("appliedStatTotal: " + appliedStatTotal);
		if(entries!=null)
		{
//			System.out.println("entries count: " + entries.length);
			printArrayOfRosterRanks(entries);
		}
	}
	public void printArrayOfRosterEntries(rosterEntry[] entries)
	{
		for(int i=0; i < entries.length; i++)
		{
			entries[i].print();
		}
	}
	public void printArrayOfRosterRanks(rosterEntry[] entries)
	{
		for(int i=0; i < entries.length; i++)
		{
			entries[i].printRosterRanks();
		}
	}

}
