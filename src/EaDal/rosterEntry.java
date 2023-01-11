package EaDal;

import com.google.gson.JsonObject;

public class rosterEntry {

	public double acquisitionDate;
	public String acquisitionType;
	public String injuryStatus;
	public int lineupSlotId;
	public int[] pendingTransactionIds;
	public int playerId;
	public playerPoolEntry playerPoolEntry;
	
	public void print()
	{
		System.out.println("acquisitionDate: " + acquisitionDate);
		System.out.println("acquisitionType: " + acquisitionType);
		System.out.println("injuryStatus: " + injuryStatus);
		System.out.println("lineupSlotId: " + lineupSlotId);
		System.out.println("pendingTransactionIds: " + pendingTransactionIds);
		System.out.println("playerId: " + playerId);
		playerPoolEntry.print();
	}
	public void printRosterRanks()
	{
//		System.out.println("playerId: " + playerId);
		playerPoolEntry.printPlayerRanks();
	}
}
